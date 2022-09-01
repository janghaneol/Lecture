package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/HTML; charset=utf-8");
		PrintWriter out = response.getWriter();
		String message = "서블릿은 동적 HTML 작성을 위한 웹 컴포넌트 입니다.";
		RequestDispatcher rd = request.getRequestDispatcher("gugudan");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>오늘부터 웹서버 프로그래밍</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+message+"</h2>");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
