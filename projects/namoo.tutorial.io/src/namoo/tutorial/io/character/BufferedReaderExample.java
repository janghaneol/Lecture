package namoo.tutorial.io.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderExample {
	
	static final String path = "./src/namoo/tutorial/io/FileExample.java";
	static final String path2 = "./src/namoo/tutorial/io/FileExample2.java";
	
	public static void main(String[] args) throws IOException {
		File file = new File(path);
		
		if(!file.exists()) {		//경로에 파일이 존재하지 않는다면,
			System.out.println("읽고자하는 파일이 없습니다.");
			return;					// 메인클래스를 종료한다. 훨씬 가벼워지고 효율적인 코드가 됨
		}
		
		FileReader in = new FileReader(path);			//입력스트림
		BufferedReader br = new BufferedReader(in);
		
		FileWriter out = new FileWriter(path2);			//출력스트림
		BufferedWriter bw = new BufferedWriter(out);
		
//		String line = br.readLine();	//BufferedReader는 파일을 1줄 단위로 읽는다.
//		System.out.println(line);
		
		String line = null;
		
		while( (line = br.readLine()) != null) {	//bufferedReader는 빈 공간일 경우 null값이 된다.
//			System.out.println(line);
			bw.write(line + "\n");			// readLine() 메소드는 라인별로 읽지만 띄어쓰기를 제공하지 않는다.
		}
		br.close();
		bw.close();
		System.out.println("복사 완료");	// FileReader 와 FileWriter로 쉽게 파일 복사가 가능하다.
		
	}

}
