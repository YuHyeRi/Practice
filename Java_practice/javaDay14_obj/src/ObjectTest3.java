// String Ŭ������ StringBuffer Ŭ���� ����

public class ObjectTest3 {
	public static void main(String[] args) {
		// String Ŭ���� : ������ �� ������ �ʴ� ���ڿ��� �����ϰų� ������ ���� ���ڿ�
		// StringBuffer Ŭ���� : String���� ������ �����ϴ�
		
		String s1;
		s1 = new String("rainbow");
		s1.charAt(0);	// String Ŭ������ ��¸� ����
		
		StringBuffer s2 = new StringBuffer();
		s2.append("Hello");	// �߰�����
		s2.setCharAt(0, 'Y');	// 0��° index�� ���ڸ� H�� ����
		System.out.println(s2);
		
		// �ڹٿ��� �ڵ尡 ����Ǵµ����� �ɸ��� �ð� �����ϱ�
		// currentTimeMillis(); �Լ� ���°� �˾Ƶα�!
		long start = System.currentTimeMillis();	// ����ð��� �и��ʴ�����
		int sum = 0;
		for(int i=0; i<=100000; i++) {
			sum+=i;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.printf("�ɸ��ð� : %d\n", end - start);
		
		start = System.currentTimeMillis();
		for(int i=1; i<=10000; i++) {
			s1+=String.valueOf(i);		// String.valueOf : ���ڸ� ���ڿ��� ��ȯ�ϴ� �Լ� 
		}
		end = System.currentTimeMillis();
		System.out.printf("�ɸ��ð� : %d\n", end - start);
		
		start = System.currentTimeMillis();
		for(int i=1; i<=10000; i++) {
			s2.append(String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.printf("�ɸ��ð� : %d\n", end - start);
	}
}
