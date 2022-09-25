package student.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

import student.dto.Student;
import student.mapper.StudentMapper;


/**
 * Student Service Servlet
 */
//@WebServlet("/students")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	// 학생 목록 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession;
		String resource = "mybatis-config.xml";
		Reader reader = null;
		reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlsessionfactory.openSession();
		
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map result = new HashMap();
		List<Student> studentList = new ArrayList<Student>(mapper.search());
		
		result.put("studentList", studentList);
		Gson gson = new Gson();
		String stu = gson.toJson(studentList);
		PrintWriter pw = response.getWriter();
		response.setContentType("aplication/json; charset=utf-8");
		pw.print(stu);
//		System.out.println(stu);
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession;
		String resource = "mybatis-config.xml";
		Reader reader = null;
		reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlsessionfactory.openSession(true);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map result = new HashMap();
		Student student = gson.fromJson(in, Student.class);
		System.out.println(student);
		
		mapper.create(student);
		
	}

}
