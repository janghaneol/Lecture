package namoo.yorizori.controller.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.external.Movie;
import namoo.yorizori.service.external.CrawlingService;

/**
 * CGV상영 예정작을 보여줄 Servlet
 */
@WebServlet("/movie/reserve/list.do")
public class ReserveLisetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrawlingService crawlingService = ServiceFactoryImpl.getInstance().getCrawlingService();
		List<Movie> list = crawlingService.reserveMovieList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/movie/reserveList.jsp").forward(request, response);
	}

}
