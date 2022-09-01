package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.common.factory.JdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;

/**
 * Servlet에서 DB 연동하기
 * @author Administrator
 *
 */
public class DBServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDao userDao = JdbcDaoFactory.getInstance().getUserDao();
		System.out.println(userDao);
		try {
			List<User> list = userDao.list();
			System.out.println(list);
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>회원목록</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/001.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<table>");
			out.println("<caption>회원 목록</caption>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th id=\"fn\" scope=\"col\">아이디</th>");
			out.println("<th id=\"fr\" scope=\"col\">이름</th>)");
			out.println("<th id=\"to\" scope=\"col\">이메일</th>");
			out.println("<th id=\"dp\" scope=\"col\">가입일자</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tfoot>");
			out.println("<tr>");
			out.println("<td colspan=\"4\">Total: "+ list.size()+ " 명</td>");
			out.println("</tr>");
			out.println("</tfoot>");
			
			out.println("<tbody>");
			
			for (User user : list) {
				out.println("<tr>");
				out.println("<td>"+user.getId()+"</td>");
				out.println("<td>"+user.getName()+"</td>");
				out.println("<td>"+user.getEmail()+"</td>");
				out.println("<td>"+user.getRegdate()+"</td>");
				out.println("</tr>");
			}
			
			out.println("</tbody>");
			
			out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
