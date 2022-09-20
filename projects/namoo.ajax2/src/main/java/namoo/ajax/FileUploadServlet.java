package namoo.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;


/**
 * Servlet implementation class CookbookRegistController
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		Part part = request.getPart("infile");
		long fileSize = part.getSize();
		String fileName = part.getSubmittedFileName();
		System.out.println(fileName);
		System.out.println(fileSize);
		
		File file = new File("D:/Lecture/projects/upload/");
		if(!file.exists()) {
			file.mkdirs();
		}
//		업로드 파일 저장
		part.write(file.getAbsolutePath()+ File.separator + fileName);
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("파일 정상 업로드 처리 완료");
		
	}

}

