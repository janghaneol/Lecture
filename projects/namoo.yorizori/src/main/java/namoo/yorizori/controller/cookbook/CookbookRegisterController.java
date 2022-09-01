package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import namoo.yorizori.common.factory.JdbcDaoFactory;
import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.user.User;

/**
 * Servlet implementation class CookbookRegistController
 */
@WebServlet("/cookbook/register.do")
public class CookbookRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("loginUser");
			
			if(user== null) {
				String referer = req.getHeader("referer");
				throw new YZRuntimeException("요리책을 등록하려면 로그인이 필요합니다.", referer);
			}
			else {
				req.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookForm.jsp").forward(req, resp);
			}
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String book_name = request.getParameter("book_name");
		String book_desc = request.getParameter("book_desc");
		String author_id = request.getParameter("author_id");
		Cookbook cookbook = new Cookbook();
		
		cookbook.setAuthor_id(author_id);
		cookbook.setBook_desc(book_desc);
		cookbook.setBook_name(book_name);
		try {
			ServiceFactoryImpl.getInstance().getCookbookService().registerCookbook(cookbook);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.sendRedirect(request.getContextPath());
		
	}

}

