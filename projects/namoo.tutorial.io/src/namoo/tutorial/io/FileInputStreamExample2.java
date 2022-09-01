package namoo.tutorial.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *  파일에서 데이터 읽어들이기
 * 
 */
public class FileInputStreamExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Work\\tools\\D2Coding-Ver1.3.2-20180524.zip";
		// Stream API를 이용하여 입력받기
		try {
			FileInputStream fin = new FileInputStream(path);
			System.out.println(fin.available());
			
			// 배열(계란판)로 효율적으로 읽기
			byte[] array = new byte[4*1024]; //4KB = 4*1024
			int count = 0;
			int filesize = 0;
			while ((count = fin.read(array)) != -1 ) {
				
				filesize += count;
				System.out.println(fin.available()); //1번씩 호출될때마다 4kb씩 줄어든 값이 출력된다 .
			}
			System.out.println("읽어들인 파일 사이즈 : " + filesize);
			
			fin.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
