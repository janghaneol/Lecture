package namoo.tutorial.network.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/*
 *  접속 클라이언트와 메세지 송수신을 담당하는 독립적인 쓰레드
 * 
 */
public class ChatThread extends Thread {
	// 쓰레드의 인스턴스 변수
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ChatService chatService;
	/**
	 * @param socket
	 * @throws IOException
	 */
	public ChatThread(Socket socket, ChatService chatService) throws IOException {
		this.socket = socket;
		this.chatService = chatService;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public PrintWriter getOut() {
		return out;
	}
	/**
	 * 자기자신(클라이언트) 메시지 전송
	 * @param message
	 */
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}

	@Override

	public void run() {
		// TODO Auto-generated method stub
//			클라이언트 전송 데이터 수신
		String message = null;
		String clientIP = socket.getInetAddress().getHostAddress();
		try {
			while ((message = in.readLine()) != null) {
				System.out.println("수신데이터 : " + message);
				if (message.equalsIgnoreCase("bye")) {
					System.out.printf("클라이언트 %s가 연결을 종료하였습니다.", clientIP);
					break;
				}
				//모든 클라이언트에게 메시지 에코
				chatService.sendAllMessage(message);
			}
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
