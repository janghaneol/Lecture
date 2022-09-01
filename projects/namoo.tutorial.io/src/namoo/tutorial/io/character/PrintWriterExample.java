package namoo.tutorial.io.character;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class PrintWriterExample {
	static final String path = "./sample6.txt";
	
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(path);
		out.print("대한민국");
		out.println(" 만세");
		out.printf("%1$tF %1$tT %1$tA",Calendar.getInstance());
		out.close();
		System.out.println("출력완료");
		
//		텍스트 파일의 내용을 읽을때는 BufferedReader를 가지고 읽고
//		파일에 텍스트를 출력할때는 PrintWriter를 이용하는것이 좋다.
		
	}

}
