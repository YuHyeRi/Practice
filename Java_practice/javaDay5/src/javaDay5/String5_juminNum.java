package javaDay5;

public class String5_juminNum {
	// �ֹι�ȣ �ǵ��ϱ�
	public static void main(String[] args) {
		
		String jumin = "6407131018433";
		
		int lastCheck = jumin.charAt(12)-'0';
		
		int a1; 
		a1  = (jumin.charAt(0) - '0') * 2;
		a1 += (jumin.charAt(1) - '0') * 3;
		a1 += (jumin.charAt(2) - '0') * 4;
		a1 += (jumin.charAt(3) - '0') * 5;
		a1 += (jumin.charAt(4) - '0') * 6;
		a1 += (jumin.charAt(5) - '0') * 7;
		a1 += (jumin.charAt(6) - '0') * 8;
		a1 += (jumin.charAt(7) - '0') * 9;
		a1 += (jumin.charAt(8) - '0') * 2;
		a1 += (jumin.charAt(9) - '0') * 3;
		a1 += (jumin.charAt(10) - '0') * 4;
		a1 += (jumin.charAt(11) - '0') * 5;
		System.out.println(a1);
		
		a1 = 0;
		int k = 2;
		
		for(int i=0; i<12; i++) {
			a1 += (jumin.charAt(i)-'0') * k;
			k++;
			if(k>9)
				k=2;
		}
			System.out.println(a1);
			
			a1 = a1 % 11;		// �����ѹ� : 11
			System.out.println(a1);
			
			a1 = 11 - a1;
			System.out.println(a1);
			if(a1 == lastCheck) {
				System.out.println("�ùٸ� �ֹι�ȣ �Դϴ�.");
			} else {
				System.out.println("�߸��� �ֹι�ȣ �Դϴ�.");
			}
		
	}
}
