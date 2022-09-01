package namoo.tutorial.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *  자바 기본 데이터타입별로 쓰기
 */
public class DataInputStreamExample {

	static final String path = "./sample3.dat";
	
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		boolean isMan = false;
		char gender = 0;
		int age = 0;
		double weight = 0.0;
		String message = null;
		
		isMan = in.readBoolean();
		gender = in.readChar();
		age = in.readInt();
		weight = in.readDouble();
		message = in.readUTF();
		
		System.out.println(isMan);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		in.close();
		
	}

}
