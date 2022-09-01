package namoo.tutorial.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  자바 기본 데이터타입별로 쓰기
 */
public class DataOutputStreamExample {

	static final String path = "./sample3.dat";
	
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		boolean isMan = true;
		char gender = 'm';
		int age = 30;
		double weight = 72.5;
		String message = "자바 HTML CSS, JavaScript SQL....";
		
		out.writeBoolean(isMan);
		out.writeChar(gender);
		out.writeInt(age);
		out.writeDouble(weight);
		out.writeUTF(message);
		
		
	}

}
