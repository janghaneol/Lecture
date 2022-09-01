package namoo.tutorial.io.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	
	static final String path = "./src/namoo/tutorial/io/FileExample.java";
	
	public static void main(String[] args) throws IOException {
		File file = new File(path);
		if(!file.exists()) {		//경로에 파일이 존재하지 않는다면,
			System.out.println("읽고자하는 파일이 없습니다.");
			return;					// 메인클래스를 종료한다. 훨씬 가벼워지고 효율적인 코드가 됨
		}
		
		FileReader reader = new FileReader(path);
	
		
//		int data = reader.read();				//2byte짜리로 읽기
//		int data = 0;
//		while((data = reader.read()) != -1) {
//			System.out.print((char)data);
//		}
//		reader.close();
		
//		char[] chars = new char[1024];			// 1024byte짜리 char형 배열로 읽는 법 
//		int count = 0;
//		while((count = reader.read(chars)) != -1) {
//			System.out.print(new String(chars, 0, count));
//		}
//		reader.close();
		
		// File클래스를 이용해 파일의 크기만큼 바로 읽는 법
		char[] chars = new char[(int)file.length()];	
		int count = reader.read(chars);
		System.out.print(new String(chars, 0, count));
		reader.close();
		
	}

}
