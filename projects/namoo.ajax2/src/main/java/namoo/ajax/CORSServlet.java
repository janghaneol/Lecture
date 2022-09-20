package namoo.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CORSServlet
 */
@WebServlet("/albums")
public class CORSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		URL url = new URL("https://yts.torrentbay.to/api/v2/list_movies.json?quality=3D");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		int status = connection.getResponseCode();
		String text = null;
		
		// Error 
		if(status > 299) {
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((text=in.readLine()) != null) {
				sb.append(text);
			}
		}else {	//정상 데이터 수신
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((text=in.readLine()) != null) {
				sb.append(text);
			}
		}
		in.close();
		//클라이언트에게 JSON 출력
		out.print(sb.toString());
		// 디버깅
		System.out.println(sb.toString());
		out.close();
	}

}
