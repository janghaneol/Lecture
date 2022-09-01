package namoo.tutorial.io;

import java.util.Calendar;
import java.util.Formatter;

/*
 * 다양한 출력 형식 사용하기
 * 
 */

public class FormmatterExample {

	public static void main(String[] args) {
		String message = "자바는 객체지향 언어이다.";
		//Formatter ft = new Formatter();
		//System.out.println(ft.format("%1$-20s", message).toString());
		//System.out.println(ft);
		
		System.out.printf("%1$-20s", message);
		System.out.println();
		int age = -301313131 ;
		double weight = 71.556;
		System.out.printf("나이는 %-+,(5d이고,",age);
		System.out.printf("몸무게는 %-+,5f이다.\n", weight);
		
		Calendar now = Calendar.getInstance();
		//2022-6-14 00:00 0요일 00초
		System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", now);
		System.out.printf("%1$tF %1$tT\n",now);
		
		System.out.println(String.format("%1$tF %1$tT",now)); //콘솔창이 아닌 다른곳에 문자열을 보내려고할때 String.format을 이용하면 된다.
		
		
	}

}
