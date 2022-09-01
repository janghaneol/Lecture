package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.user.dto.User;

/**
 * Servlet implementation class HelloServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/HTML; charset=utf-8");
		PrintWriter out = response.getWriter();
//		세션으로 로그인정보 확인
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
		
		String loginId = null;
		String regDate = null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("id")) {
					loginId = cookie.getValue();
				}
				if(cookie.getName().equals("date")) {
					regDate = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
			}
		}

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>Document</title>");
		out.println("<style>");
		out.println("header{");
		out.println("height : 30px;");
		out.println("background-color: blue;");
		out.println("}");
		out.println("ul{");
		out.println("border: 2px dashed black;");
		out.println("background-color: aqua;}");
		out.println("nav>ul>li{");
		out.println("background-color: red;");
		out.println("display: inline-block;");
		out.println("width: 100px;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<header>");
		
		if (loginId != null) {
			out.println("<h4>"+loginId+"("+regDate+")"+"님 로그인 중</h4>");
			out.println("<a href='login.do'>로그아웃</a>");
		}else {
		out.println("<form action=\"login.do\" method=\"post\">");
		out.println("<input type=\"text\" name=\"id\" maxlength=\"8\">");
		out.println("<input type=\"password\" name=\"passwd\" maxlength=\"8\">");
		out.println("<input type=\"submit\" value=\"로그인\">");
		out.println("</form>");
		}
		out.println("</header>");
		out.println("<nav id=\"container\">");
		out.println("<ul>");
		out.println("<li>메뉴1</li>");
		out.println("<li>메뉴2</li>");
		out.println("<li>메뉴3</li>");
		out.println("</ul>");
		out.println("</nav>");
		out.println("</body>");
		out.println("</html>");
	}

}
