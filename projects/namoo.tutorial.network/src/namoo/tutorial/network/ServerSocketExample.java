package namoo.tutorial.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import namoo.tutorial.network.chat.server.ChatThread;

/*
 * 클라이언트의 연결을 수신하고, 특정 서비스를 제공하기 위해
 * ServerSocket를 생성한다.
 * 
 */
public class ServerSocketExample {
	static final int PORT = 2022;

	public static void main(String[] args) {
		try {
//			서버소켓 생성
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("서버가 정상구동되었습니다.");

			while (true) {
//			블락메소드 -> 클라이언트가 접속해 올떄까지 블락메소드
				Socket socket = serverSocket.accept(); // 클라이언트가 접속하기위해 서버가 구동된 상태로 대기함
				String clientIP = socket.getInetAddress().getHostAddress(); // 클라이언트의 ip주소를 얻기위한 socket의 클래스
				System.out.printf("클라이언트[%s]가 접속되었습니다.", clientIP);

				// 스레드를 생성 및 시작해야되는 위치
//				ChatThread chatThread = new ChatThread(socket);
//				chatThread.start();
			}
		}

//			InputStream in = socket.getInputStream();
//			OutputStream out = socket.getOutputStream();

		catch (IOException e) {
			System.err.println("포트(" + PORT + ")충돌로 서버를 구동할 수 없습니다.");
		}

	}
}
