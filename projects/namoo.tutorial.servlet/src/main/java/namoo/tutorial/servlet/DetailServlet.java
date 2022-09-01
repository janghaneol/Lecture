package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */

public class DetailServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		요청메세지의 요청라인 정보 출력
		System.out.println(request);
		System.out.println(response);
		
		System.out.println("브라우저 요청 방식 : "+request.getMethod());
		System.out.println("브라우저 요청 URI : "+request.getRequestURI());
		System.out.println("브라우저 요청 URL : "+request.getRequestURL());
		System.out.println("브라우저 사용 프로토콜 : "+request.getProtocol());
		
//		브라우저 요청메시지의 헤더정보들을 출력하는 방법
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			String value = request.getHeader(key);
			System.out.println(key + " : " + value);
		}
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getQueryString());
		System.out.println(request.getContextPath());
		System.out.println(request.getContentType());
	}

}
