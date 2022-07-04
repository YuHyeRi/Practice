package javaDay3;

import java.util.Scanner;

public class For_Exam3_Extra {
	// 10°³ ÀÔ·Â¹Þ¾Æ, Â¦¼ö´Â Â¦¼ö³¢¸® Æò±Õ, È¦¼ö´Â È¦¼ö³¢¸® Æò±Õ ±¸ÇÏ±â
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int evenSum = 0;	// Â¦¼öÇÕ
		int evenCnt = 0;	// Â¦¼ö¸î°µÁö
		int oddSum = 0;		// È¦¼öÇÕ
		int oddCnt = 0;		// È¦¼ö¸î°µÁö
		int num; // µ¥ÀÌÅÍ ÀÐÀ¸¸£ º¯¼ö
		int i;	// ¿·¿¡¼­ ¼¼¾îÁÙ º¯¼ö
		
		for(i = 1; i <= 10; i++) {
			System.out.println("Á¤¼öÀÔ·Â" + i + ": ");
			num = sc.nextInt();
			if(num % 2 == 0) {
				evenSum += num;
				evenCnt++;
			} else {
				oddSum += num;
				oddCnt++;
			}
		}
		if(evenCnt > 0) {
			System.out.printf("Â¦¼öÇÕ %d\n", evenSum + evenCnt);
			System.out.printf("Â¦¼öÆò±Õ %d\n", evenSum / evenCnt);
		}
		if(oddCnt > 0) {
			System.out.printf("È¦¼öÇÕ %d\n", oddSum + oddCnt);
			System.out.printf("È¦¼öÆò±Õ %d\n", oddSum / oddCnt);
		}
		}
}
