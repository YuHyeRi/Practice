// ����Ŭ���� : Ŭ���� ���ο� Ŭ������ ���� (�����ߺ��ٴ� �ȵ���̵尳�߽� �ַ� ��)
class Outer {
	int x, y;
	Inner inner = new Inner();
	
	public void calculate() {
		this.x = 10;
		this.y = 20;
		System.out.println(inner.add());
		inner.add();
	}
	
	class Inner {				  // ����Ŭ���� : Iterator �����, �̺�Ʈ ���α׷��ֽ�
		int add() { return x+y; } // ����Ŭ�������� �ܺ�Ŭ���� ������ �����Ӱ� ���� ����!
		int sub() { return x-y; }
		int mul() { return x*y; }
		int div() { return x/y; }
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer o1 = new Outer();
		o1.calculate();
	}
}
