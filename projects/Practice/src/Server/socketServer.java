package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer {
	
	static final int PORT = 2022;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("서버가 구동되었습니다.");
			
			while(true) {
				Socket socket = serverSocket.accept();
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.printf("클라이언트 [%s]가 접속했습니다.", clientIP);
				
				BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				
				String message = null;
				while((message = br.readLine()) != null) {
					System.out.println("수신 메세지 : " + message);
					if(message.equalsIgnoreCase("bye"))
						break;
					
					pw.println(message);
					pw.flush();
				}
				System.out.println("클라이언트가 접속을 해제했습니다.");
				socket.close();
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
