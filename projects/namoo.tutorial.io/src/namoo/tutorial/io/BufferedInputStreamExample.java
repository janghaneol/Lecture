package namoo.tutorial.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *  효율적으로 읽기 및 조작
 * 
 */
public class BufferedInputStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Work\\tools\\D2Coding-Ver1.3.2-20180524.zip";
		// Stream API를 이용하여 입력받기
		try {
			//Node Stream
			FileInputStream fin = new FileInputStream(path);
			// Fileter Stream   -> 단독적으로 생성되지 않고 반드시 노드스트림이 필요하다.
			BufferedInputStream bis = new BufferedInputStream(fin);
			
			
			
//			int data = 0;
//			while((data = bis.read()) != -1) {
//				System.out.println(data);
				
//			}
//			System.out.println("입력완료");
			
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(0);	// -> 4번째 byte에 마킹을 한 상태
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.skip(20);	// -> 7번재 byte에서 20byte를 건너 뛰겠다
			System.out.println(bis.read());
			bis.reset();
			System.out.println(bis.read());	// -> 마킹을 해놓은 4번째 byte로 돌아간다.
			bis.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
