package namoo.tutorial.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample2 {
	
	static final String PATH = "./sample2.txt";
	
	public static void main(String[] args) throws IOException {	//IOException이 FileNotFoundException보다 상위 클래스
			OutputStream out = new FileOutputStream(PATH, true);	//다형성. 상위클래스를 선언하면 하위래스를 모두 선언할 수 있다.
			byte[] buffer = new byte[1024];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = (byte)i;
			}
			out.write(buffer,0,buffer.length-1);
			out.close();
			System.out.println("파일 출력 완료..");
		
		
	}

}
