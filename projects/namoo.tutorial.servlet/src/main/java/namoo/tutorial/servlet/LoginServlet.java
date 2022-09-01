package namoo.tutorial.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.common.factory.JdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;

/**
 * 로그인 처리 서블릿
 */
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		UserDao userDao = JdbcDaoFactory.getInstance().getUserDao();
		try {
			User user = userDao.login(id, passwd);
//			사용자 정보를 세션에 저장하기
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
//			response.sendRedirect("index.do");

//			사용자 정보를 브라우저 쿠키에 저장하기
			Cookie idCookie = new Cookie("id", user.getId());
			Cookie dateCookie = new Cookie("date", URLEncoder.encode(user.getRegdate(), "utf-8"));

			response.addCookie(idCookie);
			response.addCookie(dateCookie);
			response.sendRedirect("index.do");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 로그아웃 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		세션방식으로 로그아웃 처리하는방법
//		HttpSession session = request.getSession();
//		session.invalidate();
//		response.sendRedirect("index.do");
		
//		쿠키방식으로 로그아웃 처리하는방법
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id") || cookie.getName().equals("date")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			response.sendRedirect("index.do");
		}
	}
}
