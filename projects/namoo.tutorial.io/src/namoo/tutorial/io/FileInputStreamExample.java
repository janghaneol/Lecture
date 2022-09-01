package namoo.tutorial.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *  파일에서 데이터 읽어들이기
 * 
 */
public class FileInputStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Work\\tools\\D2Coding-Ver1.3.2-20180524.zip";
		// Stream API를 이용하여 입력받기
		try {
			FileInputStream fin = new FileInputStream(path);
			
			int data = 0;
			while((data = fin.read()) != -1) {
				System.out.println(data);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
