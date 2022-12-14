package namoo.yorizori.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dto.user.User;

/**
 * 로그인 화면 컨트롤러
 */
@WebServlet("/user/login.do")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveId = request.getParameter("saveid");
		
		User loginUser = ServiceFactoryImpl.getInstance().getUserService().signIn(id, passwd);		
			
			if(loginUser != null) {
				HttpSession loginSession = request.getSession();
				loginSession.setAttribute("loginUser", loginUser);
				
				if(saveId != null) {
					Cookie saveIdCookie = new Cookie("saveId", loginUser.getId());
					saveIdCookie.setMaxAge(60*60*24*30); //클라이언트에 한달 저장
					saveIdCookie.setPath("/");
					response.addCookie(saveIdCookie);
				}
				
				response.sendRedirect(request.getContextPath());
			} else {
				// 회원이 아닌 경우
//				throw new RuntimeException("사용자로그인에 실패하였습니다.");
				String referer = request.getHeader("referer");
				throw new YZRuntimeException("사용자 로그인에 실패하였습니다.",referer);
			}
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession loginSession = req.getSession();
		loginSession.invalidate();
		resp.sendRedirect(req.getContextPath());
	}

}
