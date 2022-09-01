package namoo.tutorial.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample {
	
	static final String PATH = "./sample.txt";
	
	public static void main(String[] args) throws IOException {	//IOException이 FileNotFoundException보다 상위 클래스
			OutputStream out = new FileOutputStream(PATH, true);	//다형성. 상위클래스를 선언하면 하위래스를 모두 선언할 수 있다.
			out.write(97);		//아스키코드 소문자a  --> 숫자를 디코딩해서 샘플에 전달한다.
			out.write(98);
			out.write(99);
			out.write(100);
			out.close();
			System.out.println("파일 출력 완료..");
		
		
	}

}
