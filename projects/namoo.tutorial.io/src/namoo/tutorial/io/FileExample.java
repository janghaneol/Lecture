package namoo.tutorial.io;

import java.io.File;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;

/*
 * 파일(디렉토리) 정보 조회 및 조작
 * 
 */
public class FileExample {

	public static void main(String[] args) {
//		파일 정보 조회
		/*
		 * String path = System.getProperty("user.dir"); System.out.println(path);
		 * 
		 * Properties prop = System.getProperties(); Enumeration<Object> keys =
		 * prop.keys(); while(keys.hasMoreElements()) { String key =
		 * (String)keys.nextElement(); String value = prop.getProperty(key);
		 * System.out.println(key + " = " + value);
		 * 
		 * } System.out.println();
		 * 
		 * String download = System.getProperty("user.home") + File.separator +
		 * "Downloads"; System.out.println(download);
		 */
		 
		File file = new File("./sample.txt");
		boolean exist = file.exists();
		System.out.println(exist);
		System.out.println("get name : " + file.getName());
		System.out.println("get parent : " + file.getParent());
		System.out.println("get path : " + file.getPath());
		System.out.println("get AbsolutePath : " + file.getAbsolutePath());
		System.out.println("length : " + file.length());
		System.out.println("isDirectory : " + file.isDirectory());
		System.out.println("isFile : " + file.isFile());
		
		
		System.out.println("lastFix : " + file.lastModified());
		
		long ms = file.lastModified();
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal.get(Calendar.YEAR));
		//System.out.println(cal);
		cal.setTimeInMillis(ms);
		
		/*
		 * int year = cal.get(Calendar.YEAR); int month = cal.get(Calendar.MONTH) + 1;
		 * int day = cal.get(Calendar.DATE);
		 * 
		 * System.out.println("변경일자 : " + year +"-"+ month +"-"+ day);
		 */
		System.out.printf("%1$tF %1$tT",cal);
		
		
		System.out.println();
		
//		파일 목록 조회
		
		File directory = new File("C:\\Program Files\\Common Files");
		File[] list = directory.listFiles();
		for (File element : list) {
			if(element.isDirectory()) {
				System.out.println("<DIR>" + element.getName());
			}
			else {
				
				System.out.println(element.length() + " " +  element.getName());
			}
			System.out.println(element.getName());
		}
//		빈 디렉토리 생성
		/*
		 * File dir = new File("my-directory"); boolean ok = dir.mkdir(); if(ok) {
		 * System.out.println("디렉토리 생성 완료"); }else { System.out.println("디렉토리 생성 실패"); }
		 */
		
		File dir = new File("some/my-directory");	//2개의 디렉토리를 생성할땐
		dir.mkdirs();								//mkdir()이 아닌 복수형 mkdirs()를 사용하면 된다.
		System.out.println("완료");
		
	}

}
