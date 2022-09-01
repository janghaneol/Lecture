package namoo.tutorial.network.chat.server;

/**
 * 채팅 클라이언트의 요청에 대한 다양한 서비스 제공
 * @author Administrator
 *
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatService {

	public static final int PORT = 2022;
	private boolean running;
	private ServerSocket serverSocket;
	private List<ChatThread> clients;

	/**
	 * 생성자에서 직접 serverSocket을 초기화
	 * 
	 * @throws IOException
	 */
	public ChatService(int size) throws IOException {
		clients = new ArrayList<ChatThread>(size);
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public List<ChatThread> getClients() {
		return clients;
	}

	/**
	 * 서비스 시작
	 * 
	 * @throws IOException
	 */
	public void startUp() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
		running = true;
	}

	/**
	 * 접속 클라이언트 연결 수신
	 * 
	 * @throws IOException
	 */
	public void connectListening() throws IOException{
		while (running) {
//			블락메소드 -> 클라이언트가 접속해 올떄까지 블락메소드
			Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 클라이언트가 접속하기위해 서버가 구동된 상태로 대기함
			String clientIP = socket.getInetAddress().getHostAddress(); // 클라이언트의 ip주소를 얻기위한 socket의 클래스
			System.out.printf("클라이언트[%s]가 접속되었습니다.", clientIP);

			// 스레드를 생성 및 시작해야되는 위치
			ChatThread chatThread = new ChatThread(socket, this);
			clients.add(chatThread);
			chatThread.start();
			System.out.println("접속한 클라이언트 개수 : " + clients.size());
		}
	}

	/**
	 * 서비스 종료
	 * 
	 * @throws IOException
	 */
	public void shutDown() throws IOException {
		serverSocket.close();
	}
	
	/**
	 * 모든 접속한 클라이언트에게 메시지 전송하는 기능
	 */
	
	public void sendAllMessage(String message) {
		for (ChatThread chatThread : clients) {
			chatThread.sendMessage(message);
		}
	}
}
