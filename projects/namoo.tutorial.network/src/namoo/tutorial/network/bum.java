package namoo.tutorial.network;

import java.util.Scanner;

class Human {
	String name;
	String eat;
	int age;
	int money;

}
public class bum {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human a = new Human();
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		a.name = sc.next();
		System.out.print("나이 : ");
		a.age = sc.nextInt();
		System.out.print("먹는 것 : ");
		a.eat = sc.next();
		System.out.print("돈 : ");
		a.money = sc.nextInt();
		
		System.out.printf("%d세의 %s은 %d원을 내고 %s를 먹습니다.", a.age, a.name, a.money, a.eat);
		
	}

}
