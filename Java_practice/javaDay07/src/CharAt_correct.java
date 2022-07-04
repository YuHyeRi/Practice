

import java.util.Scanner;

public class CharAt_correct {
	// 채점 및 점수 출력하기
	public static void main(String[] args) {

		final String JUNGDAP = "1234567890";	// 정답이니까 상수로 고정값 줌
		String name;
		String answer;
		String result = "";
		int score;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력값 받기
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.println("작성한 답을 입력하세요.");
		answer = sc.nextLine();
		
		// 2. 비교하기
		int i = 0;
		for(i=0; i<answer.length(); i++) {
			if(answer.charAt(i) == JUNGDAP.charAt(i)) {
				result += "O";
				cnt++;
			} else {
				result += "X";
			}
		} 
		
		// 3. 점수 계산하기 (문제당 10점)
		score = cnt * 10;
		
		// 4. 출력하기
		System.out.println(result);
		System.out.printf("맞은갯수 => %d개\n점수 => %d점", cnt, score);

		
	}
}