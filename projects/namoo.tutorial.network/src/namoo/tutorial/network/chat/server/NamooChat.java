package namoo.tutorial.network.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트의 연결을 수신하고, 특정 서비스를 제공하기 위해
 * ServerSocket를 생성한다.
 * 
 */

/**
 * Chat Server Application
 * 
 * @author Administrator
 *
 */
public class NamooChat {
	public static void main(String[] args) {
		try {
			ChatService chatService = new ChatService(100);
			chatService.startUp();
			System.out.println("채팅서버가 정상구동되었습니다.");
			chatService.connectListening();
		} catch (IOException e) {
			System.err.println("포트(" + ChatService.PORT + ")충돌로 서버를 구동할 수 없습니다.");
		}

	}
}
