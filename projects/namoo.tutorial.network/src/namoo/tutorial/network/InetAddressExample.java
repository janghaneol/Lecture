package namoo.tutorial.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 *  InetAddress 클래스는 IP Address를 추상화한 클래스이다.
 *  
 *  
 */

public class InetAddressExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 내 컴퓨터의 아이피주소 확인하기

		try {
			InetAddress ia = InetAddress.getLocalHost();
			String address = ia.getHostAddress();
			System.out.println("내 컴퓨터 아이피 : " + address);
			String name = ia.getHostName();
			System.out.println("내 컴퓨터 이름 : " + name);

			// 구글 아이피
			String domain = "www.google.com";
			InetAddress ia2 = InetAddress.getByName(domain);
			System.out.println(ia2.getHostAddress());

                                                                                    	
		} catch (UnknownHostException e) {                                          	
			// TODO Auto-generated catch block                                      	
			e.printStackTrace();                                                        
		}

	}

}
