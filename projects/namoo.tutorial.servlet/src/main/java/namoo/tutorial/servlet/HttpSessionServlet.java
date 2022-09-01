package namoo.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "김기정";
		
		HttpSession session= request.getSession(); //true
//		동일한 브라우저(클라이언트)가 요청한 모든 서블릿이 공유할 수 있도록 Session에 저장
		session.setAttribute("name", name);
		System.out.println("세션에 이름 저장 완료");
	}

}
