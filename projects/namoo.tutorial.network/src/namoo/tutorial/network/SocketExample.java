package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * socket을 이용한 서버 연결 및 데이터 송수신 클라이언트
 * 
 */
public class SocketExample {
	static final String IP = "127.0.0.1";
	static final String IP2 = "192.168.7.101";
	static final int PORT = 2022;
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(IP2, PORT);
			System.out.println("서버와 연결되었습니다.");
//			Scanner sc = new Scanner(System.in);
			
//			String message = sc.nextLine();
			
			
			
//			OutputStream out= socket.getOutputStream();		//문자열을 전송해야하므로 1바이트나 배열은 비효율적.
//			PrintWriter pw = new PrintWriter(out);			//필터스트림을 이용해야된다.
//			InputStream in = socket.getInputStream();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			PrintWriter out = new PrintWriter(socket.getOutputStream());	
			
			String message = null;
			Scanner scanner = new Scanner(System.in);
			
			//서버로 메시지 전송
			while((message = scanner.nextLine()) != null) {
			out.println(message);
			out.flush();
			
			if(message.equalsIgnoreCase("bye"))
				break;
			
			String serverMessage = in.readLine();
			System.out.println(serverMessage);
			}
//			out.close();
			socket.close();	//소켓만 닫으면 PrintWriter는 닫지 않아도 자동으로 닫힌다.
			
		
			
		} catch (UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.err.println("네트워크 장애로 서버를 연결할 수 없습니다.");
		}
		
	}

}
