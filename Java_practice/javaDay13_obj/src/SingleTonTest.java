
public class SingleTonTest {
	public static void main(String[] args) {
		
		// Error message : The constructor SingleTon() is not visible 
		// Singleton s1 = new SingleTon();
		
		SingleTon s1 = SingleTon.getInstance();
		SingleTon s2 = SingleTon.getInstance();
		SingleTon s3 = SingleTon.getInstance();
		
		// ���� ��ü ==> ��½� �ּҰ� ��� ���� ����
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		s1.x = 10;
		s1.arr[0] = 20;
		
		System.out.println(s2.x);
		System.out.println(s2.arr[0]);
	}
}
