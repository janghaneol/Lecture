package namoo.yorizori.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.factory.JdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dto.user.User;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	
	/**
	 * 로그인 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveId = request.getParameter("saveid");
		try {
			User user = JdbcDaoFactory.getInstance().getUserDao().login(id, passwd);
//			회원인 경우...
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
//				아이디저장 체크시
				if(saveId != null) {
					Cookie saveIdCookie = new Cookie("saveId", user.getId());
					saveIdCookie.setMaxAge(60*60*24*30);//클라이언트에 한달 저장
					saveIdCookie.setPath("/");
					response.addCookie(saveIdCookie);
				}
				response.sendRedirect(request.getContextPath());
			}else {
//				회원이 아닌 경우...
//				throw new RuntimeException("사용자 로그인에 실패하였습니다.로그인정보를 확인하세요.");
				String referer = request.getHeader("referer");
				throw new YZRuntimeException("사용자 로그인에 실패하였습니다.로그인정보를 확인하세요.", referer);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	로그아웃 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

}
