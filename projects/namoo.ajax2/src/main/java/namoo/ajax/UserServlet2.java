package namoo.ajax;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
/**
 * 
 * @author Administrator
 *	REST기반 API 설계
 */

@WebServlet("/users")
public class UserServlet2 extends HttpServlet { 

	private static final long serialVersionUID = 1L;

//	회원목록 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		회원목록 JSON으로 출력
		List<User> userList = new ArrayList<User>();
		Gson gson = new Gson();
		userList.add(new User("bangry1", "김기정", "bangry@gamil.com"));
		userList.add(new User("bangry2", "김기정2", "bangry@gamil.com"));
		userList.add(new User("bangry3", "김기정3", "bangry@gamil.com"));
		Map result = new HashMap();
		result.put("size", userList.size());
		result.put("userList", userList);
		String objectString = gson.toJson(result);
		System.out.println(objectString);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(objectString);
		out.close();
	}
		

	
//	회원가입 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		User user = gson.fromJson(in, User.class);
		System.out.println(user);
		
		
//		JSON 응답
		String message = gson.toJson(user);
		out.print(message);
		out.close();
		
	}

}
