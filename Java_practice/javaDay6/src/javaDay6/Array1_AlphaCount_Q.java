package javaDay6;

import java.util.Scanner;

public class Array1_AlphaCount_Q {
	// ������ �Է¹޾�, �� ���� ���� ���ĺ� ���� ī��Ʈ �ϱ�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] cnt = new int[26];	// ���ĺ� ���� : 26��
		
		System.out.println("���带 �Է��ϼ���.");
		String str = sc.nextLine();	// sc.next�� ���� ����X (sc.nextLine�� ���� ����O)
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);		// ���� ���� ==> �Է¹��� ���ڿ��� ���� �ϳ��ϳ�
			
			if(c>='A' && c<='Z')	// �빮�� A-Z�̸�
				cnt[c-'A']++;		// �迭�� 1�� ���� ī��Ʈ
									// A�� ������ A-A=0, �ε���0�� +1
									// B�� ������ B-B=0, �ε���1�� +1
			
			if(c>='a' && c<='z')	// �ҹ��� a-z�̸�
				cnt[c-'a']++;
		}
		for(int i=0; i<cnt.length; i++) {
			System.out.printf("%c ==> %d ��\n", ('A'+ i), cnt[i]);
			// 'A'+ i ==> A���� Z���� char ���·� ���
			// ��� if������ cnt �迭�� �־��� ������ ���
		}
		
	}
}
