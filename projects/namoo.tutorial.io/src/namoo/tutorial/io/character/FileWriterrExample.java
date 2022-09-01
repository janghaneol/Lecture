package namoo.tutorial.io.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterrExample {
	
	static final String path = "./sample5.txt";
	
	public static void main(String[] args) throws IOException {
		FileWriter out = new FileWriter(path);
//		String txt = "11월까지 잘 해봅시다.";
//		out.write(txt);
		
//		char c = '김';
//		out.write(c);
		
		char[] chars = {'J','A','V','A'};
		out.write(chars);
		out.close();
		System.out.println("출력완료");
	}

}
