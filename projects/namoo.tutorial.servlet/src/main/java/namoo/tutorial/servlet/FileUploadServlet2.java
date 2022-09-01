package namoo.tutorial.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 파일 업로드를 위한 서블릿
 * 
 * @author Administrator
 *
 */
public class FileUploadServlet2 extends HttpServlet {
	// String fileStorage = “d:/.../...”; --> 저장하는 위치
	private String fileStorage;
	private int limitFileSize = 2 * 1024 * 1024;

	@Override
	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");
		String size = getServletContext().getInitParameter("limitFileSize");
		if (size != null) {
			limitFileSize = Integer.parseInt(size);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Apache 제공 파일 업로드 API 사용법
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// FileUpload API 활용
		File storageDir = new File(fileStorage); // 저장위치
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

		// 파일 저장 위치
		fileItemFactory.setRepository(storageDir);

		// 파일 사이즈 제한
		fileItemFactory.setSizeThreshold(limitFileSize); // 이 메소드를 호출하지않으면 무제한으로 설정된다.
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파라메터 값 : " + item.getString("utf-8"));
				} else { // 업로드 파일
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일사이즈 : " + item.getSize());
					if (item.getSize() > 0) {
						String separator = File.separator; // 운영체제에 따라 동적으로 파일을 구분해주는 seperator
						int index = item.getName().lastIndexOf(separator);
						String fileName = item.getName().substring(index + 1);
						File uploadFile = new File(fileStorage + File.separator + fileName);
						item.write(uploadFile);
					}
				}
			}
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>파일 업로드 완료!</h2>");
			out.println("</body>");
			out.println("</html>");
			// response.sendRedirect("/파일목록처리 서블릿");
		} catch (Exception e) {
			e.printStackTrace();
			new ServletException(e.getMessage());
		}
	}
}
