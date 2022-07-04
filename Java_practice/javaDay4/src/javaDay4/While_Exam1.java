package javaDay4;

public class While_Exam1 {

	public static void main(String[] args) {
		
		// Â¦¼ö Ãâ·Â
		int i = 2;
		while(i<=10) {
			System.out.printf("%3d", i);
			i+=2;
		} System.out.println();		// ±×³É ÁÙ¹Ù²ÞÇÏ·Á°í ¾¸
		
		// È¦¼ö Ãâ·Â
		int j = 1;
		while(j<=10) {
			System.out.printf("%3d", j);
			j+=2;
		} System.out.println();
		
		// 90, 80, 70,... Ãâ·Â
		int k = 90;
		while(k>0) {
			System.out.printf("%3d", k);
			k-=10;
		}
		
	}
}
