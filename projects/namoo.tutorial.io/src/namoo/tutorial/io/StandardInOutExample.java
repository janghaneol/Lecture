package namoo.tutorial.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 표준 입출력
 * @author Administrator
 *
 */

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(10);
//		System.out.println(System.out);
//		System.out.println(System.in);
		
		System.out.print("당신의 이름을 입력하시오 : ");
//		System.in.read();	// 1byte씩 읽기 때문에 이름을 저장하기엔 작은 값.
		
//		byte[] buffer = new byte[10];
//		System.in.read(buffer);
//		String name = new String(buffer, 0, buffer.length);
//		System.out.println(name);
//		System.out.println(name.length());
		
		Scanner sc = new Scanner(System.in);
		String name =sc.nextLine();
		System.out.print("당신의 나이는 : ");
		int age = sc.nextInt();
		System.out.printf("%S %d", name, age);
		
		
		
	}

}
