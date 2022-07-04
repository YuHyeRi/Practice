package javaDay4;

public class For_Exam2 {
	// ¿¬½À¹®Á¦ 11. ¼·¾¾¿Âµµ¸¦ È­¾¾¿Âµµ·Î È¯»êÇÏ´Â Ç¥¸¦ Ãâ·ÂÇÏ½Ã¿À. (0~100µµ)
	// È­¾¾ = (¼·¾¾*1.8)+32
	public static void main(String[] args) {
		
	int i, j;
	
	for(i=1; i<=100; i++) {
		j = (int) ((i*1.8)+32);
		System.out.printf("¼·¾¾ : %dµµ ==> È­¾¾ : %dµµ\n", i, j);
		
	}
	
		
	}
}
