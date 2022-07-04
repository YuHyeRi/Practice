package javaDay6;

public class Array2_copy {
	// �迭 �����ϱ� (soft copy, hard copy)
	// java�� �迭���� �������δ� �޸𸮰� ��
	// �迭������ ���������� �����Ͱ� �ִ� ���� �ּҸ� �����ϱ� ���� ����
	// new int[1]; �̶� heap�̶�� ������ ������ �� �޸� 1���� Ȯ���ϰ�, ù��° ���� �ּҸ� ����
	// �޸𸮸� �� �ٶ��� null ���� ����
	public static void main(String[] args) {
		
		int[] a = new int[] {1,2,3,4};
		int[] b;
			
		// 1. ��������, soft copy 
		// a�� ����Ű�� ������ ���� �ּҸ� ����(��������) ==> ����, a�� b�� ���� �������� ����Ŵ
		b = a;
		a[0] = 100;		// ==> a�� b�� ������ �����Ͱ����� ����ϱ� ������ a,b ��� �ٲ�	
			
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");	// " " : ������� ==> 100 2 3 4
		} System.out.println();		
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");	// " " : ������� ==> 100 2 3 4
		} System.out.println();
			
		// 2. ��������, hard copy
		b = new int[a.length];		// a�� ������ �ִ� �����Ͱ��� ��ŭ ���ο� �޸𸮸� ����
		for(int i=0; i<a.length; i++) {
			b[i] = a[i];}		// a�� ������ b�� ���� ==> ��for���� �Ἥ �Ѱ��� �ű��

		a[0] = 50;		// ==> a�� ���� ����, b�� ������� ����(����X)
			
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");	// 50 2 3 4
		}System.out.println();
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");	// 100 2 3 4
		}
			
		}
	}