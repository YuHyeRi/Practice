package javaDay4;

public class Continue_Exam1 {
	// continue �̿��ؼ� 1~10���� ���� ����ϱ�(6�����ϰ�)
	public static void main(String[] args) {
		
		int i;
		for(i=1; i<=10; i++) {
			if(i==6)
				continue;
			System.out.printf("%3d",i);
		}
		
	}
}
