package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 	https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png
 * 	여기에 접속해서 이 파일을 내 컴퓨터의 C:\Users\Administrator\Downloads 에 저장하시오.
 * 
 */

public class Quiz {
	
	static final String urlString = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
			URL url = new URL(urlString);
			try {
				InputStream is = url.openStream();
				OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\copy.png");
				
				
				while(true) {
					int data = is.read();
					if(data == -1) {
						break;
					}
					out.write(data);
				}
				
				is.close();
				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("googlelogo_color_272x92dp.png 파일이 저장되었습니다.");
	}

}
