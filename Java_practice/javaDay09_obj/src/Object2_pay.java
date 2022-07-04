

import java.util.Scanner;

class Payment {
	String name;
	int pay, hour, totalPay;
	
	// 1. '������'�� �����̳� �غ��۾�, �����ʱ�ȭ�� ���
	// 2. '������'�� class��� ��ġ�ؾ��ϰ�, ������ ���� ���� ����(overloading)(��, ����� �޶����)
	// 3. '������'�� pubilc �����̾�� ��ü ������ ����
	// 4. ��ȯ���� ��� ��쿡�� �� �� ����(void�� �ȵ�)
	
	// ����Ʈ������ : �ٸ������ڸ� ���鶧 ��������� ������ �⺻ ��ü ������ ����
	// ==> ���� ������ �ڵ����� ��������, �Ʒ� �Ű������� �ִ� �ٸ� �����ڰ� ������ ���־�� ��!! (�̷���� �ڵ������ȵ�)
	// �⺻������ : �Ű������� ���� ������ (���α׷��Ӱ� �����ڸ� ������ ������, �Ű������� ���� �����ڰ� �ڵ�������)
	public Payment() {		// Payment p1 = new Payment();
		name = "������";
		pay = 10000;
		hour = 40;
		calculate();
	}
	
	// this.������ : ��ü �ڽ��� ����Ų��.
	// �Լ��� ù��° ���ڷ� this�� ���޵ǰ� �� �������� ��ü�� �ּҰ� ����ȴ�.
	// ex) this.name (���̸�), this.table(��å��)
	// ��ü������ �Ű������� �Ȱ����ϱ� this.�� ���༭ ������
	// �����ڴ� �Ű������� �޸� '����Ÿ�� X'
	public Payment(String name, int pay, int hour) {	// Payment p2 = new Payment("A", 20, 10000);
		this.name = name;		// name���� ���� �� name�� �ְڴ�
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
		System.out.println("������ ȣ��");
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
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("�ð���޿� : ");
	        int pay = sc.nextInt();
	        System.out.print("�ٹ��ð� : ");
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
	// main �ڵ� �ּ�ȭ�� ���������� ����
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