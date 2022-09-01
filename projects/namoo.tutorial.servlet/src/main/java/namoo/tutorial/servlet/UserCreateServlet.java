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
public class UserCreateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		한글이 DB에 옮겨질땐 반드시 선언해야됨
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User user = new User(id, passwd, name, email);
		System.out.println(user);
		
		UserDao userDao = JdbcDaoFactory.getInstance().getUserDao();
		try {
			userDao.create(user);
//			회원목록 보여주는 서블릿으로 이동
//			response.sendRedirect("db.do");
			
//			회원가입 결과를 보여주는 서블릿으로 이동
//			response.sendRedirect("result.do");   --> 리다이렉트로 선언시 사라지는 정보
			request.setAttribute("user", user);
			RequestDispatcher rd= request.getRequestDispatcher("result.do");
			rd.forward(request, response);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
