package javaDay6;

import java.util.Scanner;

public class Array1_AlphaCount_Q {
	// 문장을 입력받아, 그 문장 내의 알파벳 갯수 카운트 하기
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] cnt = new int[26];	// 알파벳 갯수 : 26개
		
		System.out.println("문장를 입력하세요.");
		String str = sc.nextLine();	// sc.next는 띄어쓰기 포함X (sc.nextLine은 띄어쓰기 포함O)
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);		// 변수 선언 ==> 입력받은 문자열의 문자 하나하나
			
			if(c>='A' && c<='Z')	// 대문자 A-Z이면
				cnt[c-'A']++;		// 배열의 1씩 증가 카운트
									// A가 들어오면 A-A=0, 인덱스0을 +1
									// B가 들어오면 B-B=0, 인덱스1을 +1
			
			if(c>='a' && c<='z')	// 소문자 a-z이면
				cnt[c-'a']++;
		}
		for(int i=0; i<cnt.length; i++) {
			System.out.printf("%c ==> %d 개\n", ('A'+ i), cnt[i]);
			// 'A'+ i ==> A부터 Z까지 char 형태로 출력
			// 상단 if문으로 cnt 배열에 넣어준 값들을 출력
		}
		
	}
}
