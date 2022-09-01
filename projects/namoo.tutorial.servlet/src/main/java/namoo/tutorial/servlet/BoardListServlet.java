package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//		게시판 리스트를 보여주는 서블릿
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DB에서 게시판 리스트를 조회
		response.setContentType("text/HTML; charset=utf-8");
		PrintWriter out = response.getWriter();
		String message = "이 서블릿은 DB에서 게시판 리스트를 조회하는 서블릿";
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>게시판 리스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+message+"</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
}
