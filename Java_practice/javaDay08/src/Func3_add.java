

public class Func3_add {
	// 1. add1 �Լ� ���� ==> ���ϰ� int
	public static int add1(int x, int y) {
		return x + y; }

	// 2. add2 �Լ� ���� ==> void
	public static void add2(int x, int y) {
		System.out.println(x + y); }
	
	// 3. sigma �Լ� ����
	public static int sigma(int limit) {
		int i, sum = 0;
		for(i=1; i<=limit; i++) 
			sum+=i;
			return sum; }
	
	public static void main(String[] args) {
		
		// ��¹�� : ���ϰ��� �ִ� ���
		int result = add1(3,5);
		System.out.println("add1�� ��� : " + result);	// ��¹�� 1
		System.out.println("add1�� ��� : " + add1(3,4));	// ��¹�� 2
		
		// ��¹�� : ���ϰ��� ���� ��� ==> void
		System.out.printf("add2�� ��� : ");
		add2(2,3);	// �Լ� �ܵ����� �� (������ ��ų�, sysout���� �� �� ����)
		
		// ��¹�� : ���ϰ��� �ִ� ���
		int result3 = sigma(100);
		System.out.println("sigma�� ��� : " + result3);		// ��¹��1
		System.out.println("sigma�� ��� : " + sigma(100));	// ��¹��2
		
		/*
		  -- ��ü �����Ͽ� �Լ� ȣ���ϴ� ��
		  -- ��ü�� ���� ȣ���ϰ� �Ǹ� 'static'�̶� Ű���� ��� ��
		  Func4 abc = new Func4();		--> Ŭ���� ��ü ����
		  abc.add2(3, 5);	--> void�� ���
		  System.out.println(abc.sigma(100));	--> ���ϰ��� �ִ� ���
		 */
	}
}
