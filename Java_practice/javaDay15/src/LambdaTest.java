// ���ٽ� : Ŭ������ �������� �ʰ� �Լ��� ȣ�⸸���� ����� ����

// 1. �Լ��� �������̽��� ����(�Լ� �ϳ��� ������ �ִ� �������̽�)
@ FunctionalInterface
interface MyNumber {
	int getMax(int num1, int num2);	// �������̽��̱⶧���� �����δ� ����
	// getMax�Լ��� "(x,y) -> (x>=y)? x:y;" ������ ���� ��
}

public class LambdaTest {
	public static void main(String[] args) {
		MyNumber max = (x,y) -> (x>=y)? x:y;	// ��� ��ü�� ������
		System.out.println(max.getMax(10,20));	// 20 ���
		
		max = (x,y) -> x+y;	// �߰��� �Լ����� ���� ����!
		System.out.println(max.getMax(10,20));	// 30 ���
		
		// �͸��� Ŭ���� : Ŭ������ ��ӹ޾� ���� �����ؾ� �ϴµ�, �̷��� ���ϰ� �����ϰ� ���� ������ Ŭ����
		// �θ�Ŭ���� ��ü���� �����ϸ鼭 {}�� �ٿ��ָ� ���ο� ��ü�� �������
		// Ŭ������ ������ �������� �ʾұ� ������ �̸��� ���� ==> �͸��� Ŭ����
		Object obj = new Object() {		// �θ�Ŭ���� ��ü�� ����
			@Override
			public String toString() {
				return "**"+super.toString()+"**";
			}
		};
		System.out.println(obj.toString());		// **LambdaTest$1@3c679bde**
	}
}
