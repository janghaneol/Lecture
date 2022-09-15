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

@WebServlet("/users")
public class UserServlet extends HttpServlet { 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestJson = "{'id': 'bangry', 'name':'김기정', 'email':'bangry@gmail.com'}";
		String requestArray = "[{'id':'bangry', 'name':'김기정', 'email':'bangry@gmail.com'},{'id':'bangry2', 'name':'김기정2', 'email':'bangry2@gmail.com'}]";
		String requestComplex = "{'id':'bangry', 'name':'김기정', 'languages':['Java', 'CSS', JavaScript']}";
//		Gson 생성
		Gson gson = new Gson();
//		수신한 Gson -> Map (역직렬화)
		Map map = gson.fromJson(requestJson, Map.class);
		System.out.println(map.toString());
		System.out.println(map.get("id"));
//		Json -> Object(javaBean)
		User user = gson.fromJson(requestJson, User.class);
		System.out.println(user.toString());
//		Json -> ArrayList
		List<User> list = gson.fromJson(requestArray, new TypeToken<ArrayList<User>>(){}.getType());
		System.out.println(list.toString());
//		Json -> 배열
		User[] array = gson.fromJson(requestArray, User[].class);
		System.out.println(array.toString());
//		Json -> Map
		Map userInfo = gson.fromJson(requestComplex, Map.class);
		System.out.println(userInfo);
		List<String> languages = (List<String>)userInfo.get("languages");
		for (String language : languages) {
			System.out.println("userInfo: " + language);
		}
		
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		User userObj = new User("bangry","김기정","bangry@gmail.com");
		String userJson = gson2.toJson(userObj);
		System.out.println(userJson);
		
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("id", "haneol");
		userMap.put("이름", "장한얼");
		userMap.put("email", "jhano9@naver.com");
		userJson = gson2.toJson(userMap);
		System.out.println(userJson);
		
		JsonObject userJsonObject = new JsonObject();
		userJsonObject.addProperty("id", "hong");
		userJsonObject.addProperty("name", "홍길동");
		userJsonObject.addProperty("email", "hong@gmail.com");
		userJson = gson2.toJson(userJsonObject);
		System.out.println(userJson);
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User("bangry1","김기정1","bangry@gmail.com"));
		userList.add(new User("bangry2","김기정2","bangry@gmail.com"));
		userList.add(new User("bangry3","김기정3","bangry@gmail.com"));
		String jsonUserList = gson2.toJson(userList);
		System.out.println(jsonUserList);
		
		Map result = new HashMap();
		result.put("size", list.size());
		result.put("userList", userList);
		String jsonComplex = gson2.toJson(result);
		System.out.println(jsonComplex);
		
	
}
//	회원가입 처리 및 회원 목록 출력 예제(JSON 기반)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
//		역직렬화
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		User user = gson.fromJson(in, User.class);
		System.out.println(user);
		
//		직렬화
		List<User> userList = new ArrayList<User>();
		userList.add(new User("bangry1", "김기정", "bangry@gamil.com"));
		userList.add(new User("bangry2", "김기정2", "bangry@gamil.com"));
		userList.add(new User("bangry3", "김기정3", "bangry@gamil.com"));
		Map result = new HashMap();
		result.put("size", userList.size());
		result.put("userList", userList);
		String objectString = gson.toJson(result);
		System.out.println(objectString);
//		JSON 응답
		out.print(objectString);
		out.close();
		
	}

}
