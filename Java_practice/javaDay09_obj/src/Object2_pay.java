

import java.util.Scanner;

class Payment {
	String name;
	int pay, hour, totalPay;
	
	// 1. '생성자'는 시작이나 준비작업, 변수초기화시 사용
	// 2. '생성자'는 class명과 일치해야하고, 여러개 만들 수도 있음(overloading)(단, 모습이 달라야함)
	// 3. '생성자'는 pubilc 권한이어야 객체 생성이 가능
	// 4. 반환형은 어떠한 경우에도 줄 수 없음(void도 안됨)
	
	// 디폴트생성자 : 다른생성자를 만들때 만들어주지 않으면 기본 객체 생성을 못함
	// ==> 따라서 원래는 자동으로 생기지만, 아래 매개변수가 있는 다른 생성자가 있으니 써주어야 함!! (이럴경우 자동생성안됨)
	// 기본생성자 : 매개변수가 없는 생성자 (프로그래머가 생성자를 만들지 않으면, 매개변수가 없는 생성자가 자동생성됨)
	public Payment() {		// Payment p1 = new Payment();
		name = "유혜리";
		pay = 10000;
		hour = 40;
		calculate();
	}
	
	// this.참조자 : 객체 자신을 가르킨다.
	// 함수의 첫번째 인자로 this가 전달되고 이 변수에는 객체의 주소가 저장된다.
	// ex) this.name (내이름), this.table(내책상)
	// 객체변수와 매개변수가 똑같으니까 this.를 써줘서 구별함
	// 생성자는 매개변수와 달리 '리턴타입 X'
	public Payment(String name, int pay, int hour) {	// Payment p2 = new Payment("A", 20, 10000);
		this.name = name;		// name으로 받은 걸 name에 넣겠다
		this.pay = pay;
		this.hour = hour;
		calculate();
	}
	
	void calculate() {
		totalPay = pay * hour;
	}
	
	void setValue(String name, int pay, int hour) {
		this.name = name;
		this.pay = pay;
		this.hour = hour;
		calculate();
	}
	
	void outPut() {
		System.out.printf("%s %d %d %d\n", name, pay, hour, totalPay);
	}
}

class PaymentManager {
	final int MAX = 3;
	Payment[] list = new Payment[MAX];
	
	public PaymentManager() {
		System.out.println("생성자 호출");
		init();
	}
	
	void init() {
		for(int i=0; i<list.length; i++) {
			list[i] = new Payment();
		}
	}
	
	void append() {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<MAX; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("시간당급여 : ");
	        int pay = sc.nextInt();
	        System.out.print("근무시간 : ");
	        int hour = sc.nextInt();
	        
	        list[i].setValue(name, pay, hour);
		}
	}
	
	void outPut() {
		for(int i=0; i<list.length; i++) {
			list[i].outPut();
		}
	}
}

public class Object2_pay {
	// main 코드 최소화가 유지보수시 좋음
	public static void main(String[] args) {
		
		PaymentManager pm = new PaymentManager();
		// pm.init();
		// pm.append();
		// pm.outPut();
		
		Payment p1 = new Payment();
		Payment p2 = new Payment("A", 20, 10000);
		
		p1.outPut();
		p2.outPut();
		
	}
}