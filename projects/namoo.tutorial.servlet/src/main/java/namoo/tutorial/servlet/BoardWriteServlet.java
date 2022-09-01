package namoo.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		가상의 글쓴이
//		String Writer = request.getParameter("writer");
//		DB 테이블에 INSERT 완료 가정
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//		response.setHeader("Location", "list.do");
//		위의 2줄짜리 코드를 간단하게 한줄로 표현이 가능.
		response.sendRedirect("list.do");
		
	}
}
