package namoo.tutorial.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 자료실 목록 조회 서블릿
 */
public class FileListServlet extends HttpServlet {
	private String fileStorage;

	@Override
	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>자료실 서블릿</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>무료자료실</h2>");
		out.println("<table border='1'>");
		out.println("<th>순번</th><th>파일명</th><th>파일사이즈</th>");
		
		File dir = new File(fileStorage);
		File[] fileList = dir.listFiles();
		for (int i=0; i<fileList.length; i++) {
			File file = fileList[i];
			String fileName = file.getName();
			long fileSize = file.length();
			out.println("<tr>");
			out.println("<td>"+(i+1)+"</td>"+"<td><a href='download.do?file="+fileName+"'>"+fileName+"</a></td>"+"<td>"+fileSize+"Byte"+"</td>");
			out.println("</tr>");
			
		}
		
		out.println("</table>");
		
		
	}
}
