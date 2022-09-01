package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
public class UserResultServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =(User)request.getAttribute("user");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원가입 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>회원 가입 결과</h2>");
		out.println("<ul>");
		out.println("<li>"+user.getId()+"<li>");
		out.println("<li>"+user.getName()+"<li>");
		out.println("<li>"+user.getEmail()+"<li>");
		out.println("</ul>");
		out.println("<a href='index.html'>홈으로</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
