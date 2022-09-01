package namoo.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextServlet
 */
public class ServletContextServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "모든 서블릿들이 공유하는 데이터";
		ServletContext context =request.getServletContext();
		context.setAttribute("message", message);
		System.out.println(message);
		
		String driver = context.getInitParameter("jdbc.driver");
		System.out.println(driver);
	}
	
}
