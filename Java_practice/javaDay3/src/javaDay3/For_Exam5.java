package javaDay3;

public class For_Exam5 {
	// ���ĺ� ¥���� ����
	public static void main(String[] args) {
		
		int i, j;		// �ƽ�Ű�ڵ� ���ڷ� ��
		char k;
		
		for(i = 0; i < 26; i++) {
			k = (char) ('A' + i);
			for(j = 0; j < 26; j++) {
			System.out.printf("%c", k);
			k++;
			if(k > 'Z') {
				k = 'A';
			}
			}
			System.out.println();
		}
	
	}	// main
}	// class
