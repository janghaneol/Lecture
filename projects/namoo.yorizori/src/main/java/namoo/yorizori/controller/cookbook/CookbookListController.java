package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.user.User;

/**
 * 
 */
@WebServlet("/cookbook/list.do")
public class CookbookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cookbook> list= null;
		try {
			list = ServiceFactoryImpl.getInstance().getCookbookService().findCookbookByAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookList.jsp").forward(request, response);
		
		
	}

}
