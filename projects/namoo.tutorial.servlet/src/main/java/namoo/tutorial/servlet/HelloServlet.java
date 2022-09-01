package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
    	 System.out.println("서블릿컨테이너에 의해 생성자 HelloServlet() 호출됨");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿컨테이너에 의해 doGet() 호출됨");
//		브라우저 Get 요청에 대한 동적 HTML 작성 및 전송
//		현재 서블릿과 웹서버간의 출력 스트림 생성
		response.setContentType("text/HTML; charset=utf-8");
		PrintWriter out = response.getWriter();
//		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//		response.sendError(HttpServletResponse.SC_NOT_FOUND);		--> 404
//		response.sendError(HttpServletResponse.SC_BAD_GATEWAY);		--> 502
//		response.sendError(HttpServletResponse.SC_FORBIDDEN);		--> 403
		
		String message = "서블릿은 동적 HTML 작성을 위한 웹 컴포넌트 입니다.";
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>오늘부터 웹서버 프로그래밍</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+message+"</h2>");
//		다른 서블릿의 값을 읽어와서 출력하는방법
		ServletContext context =request.getServletContext();
//		String msg = (String)context.getAttribute(message);
		String msg = (String)context.getAttribute("message");
		System.out.println(msg);
		out.println("<h2>"+msg+"</h2>");
		out.println("<p>ㅋ;ㅋ;ㅋ;ㅋ;ㅋ");
		out.println("</body>");
		out.println("</html>");
	}

}
