

public class Func4_gogodan {
	// 1. ���α׸��� �Լ�
	public static void displayLine(char mark, int cnt, int cnt2) {
		for(int i=1; i<=cnt; i++) {				// ��(����)
			for(int j=1; j<=cnt2; j++) {		// ��(��ĭ)
				System.out.print(mark);
			} System.out.println();}
	}
	
	// 2. ������ �Լ� 1
	public static void gugudan(int num) {
		for(int i=1; i<10; i++) {
			System.out.printf("%d x %d = %d\n", num, i, (num*i));}
		System.out.println();
	} 
	
	// 3. ������ �Լ� 2
	public static void gugudan(int start, int end) {
		if(start > end) {	// tip! �Լ� ���ۺκп� ����ó�� �ڵ带 �д�
			System.out.println("Error!\n���۰��� ���ᰪ ���� Ů�ϴ�.");
			return;		// �Լ��� �߰��� �������� �����ų �� ����
		}
		// �����ڵ�� �ڿ� ����(else�� ���� ���߿� ���������� �ǵ��� ��������)
		for(int i=start; i<=end; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i*j));
			} System.out.println();} 
	}
	
	public static void main(String[] args) {
		// 1. ���α׸��� �Լ� ����
		displayLine('*',1,10);
		
		// 2. �������Լ�1 ����
		gugudan(3);
		
		// 3. �������Լ�2 ����
		gugudan(2,4);
		
		// *����!* Java������ ������ �̸��� �Լ��� ������ ���� �� �ִ� ==> "Overloading"
		// ��, �Ű������� Ÿ�� �� ���� ���� ���� �� �Լ����� ������ ������ ��� �����ϴ�(������)
		
		// *����!*
		// int ...a ==> �����迭 : ũ�Ⱑ �ٲ�, �Ű����� ������ �����Ǿ� ���� ������ ���� �� ���
		
	}
}
