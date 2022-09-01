package namoo.tutorial.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 *  자바 기본 데이터타입들을 OS 인코딩 방식에 맞춰 출력
 */
public class PrintStreamExample {

	static final String path = "./sample4.txt";
	
	public static void main(String[] args) throws IOException {
		File file = new File(path);
		
//		PrintStream out = new PrintStream(new FileOutputStream(path));	//PrintStream은 버퍼지만 노드없이 생성이 가능하다.
//		PrintStream out = new PrintStream(path);
		PrintStream out = new PrintStream(file);
		
		
		boolean isMan = true;
		char gender = 'm';
		int age = 30;
		double weight = 72.5;
		String message = "자바 HTML CSS, JavaScript SQL....";
		
		out.println(isMan);			//콘솔창에 출력하는것이 아니라 파일에 쓰여지는것.
		out.println(gender);
		out.println(age);
		out.println(weight);
		out.println(message);
		
		out.close();
		
		System.out.println("출력완료!");
		
	}

}
