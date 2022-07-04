package javaDay1;

import java.util.Scanner;

public class Java_score {
	// 연습문제 6	
	public static void main(String[] args) {
		
		String name;
		int kor, eng, math;
		int total;
		int average;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("국어점수는?");
		kor = sc.nextInt();
		
		System.out.println("엉어점수는?");
		eng = sc.nextInt();
		
		System.out.println("수학점수는?");
		math = sc.nextInt();
		
		total = kor + eng + math;
		average = (kor + eng + math) / 3;
		
		System.out.println(name + "의 총합은 " + total + "이며, 평균은 " + average + "입니다.");
	}
}
