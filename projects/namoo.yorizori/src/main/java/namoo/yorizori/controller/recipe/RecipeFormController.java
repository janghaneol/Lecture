package namoo.yorizori.controller.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dto.user.User;


@WebServlet("/recipe/register.do")
public class RecipeFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		User user = (User)loginSession.getAttribute("loginUser");
		
		if(user == null) {
			String referer = request.getHeader("referer");
			throw new YZRuntimeException("레시피를 등록하려면 로그인해주세요", referer);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/recipe/recipeForm.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
