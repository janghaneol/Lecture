package namoo.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestJson = "{'id': 'bangry', 'name':'김기정', 'email':'bangry@gmail.com'}";
		String requestArray = "[{'id':'bangry', 'name':'김기정', 'email':'bangry@gmail.com},{'id':'bangry2', 'name':'김기정2', 'email':'bangry2@gmail.com'}]";
		String requestComplex = "{'id':'bangry', 'name':'김기정', 'languages':['Java', 'CSS', JavaScript']}";
		
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
