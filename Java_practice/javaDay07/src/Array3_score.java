

import java.util.Scanner;

public class Array3_score {
	// 평균점수, 최고점수(&심판번호), 최저점수(&심판번호) 구하기
	// 단, 평균점수는 최고점수 및 최저점수 제외후 계산
	public static void main(String[] args) {
		
		final int SIMPAN = 5;	// 심판 인원수
		double score[] = new double[SIMPAN];
		double maxScore, minScore;
		double sum = 0;
		int cnt = 0;
		int maxPos, minPos;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력값 받기
		for(int i=0; i<score.length; i++) {
			System.out.printf("심판 %d : ", i+1);
			score[i] = sc.nextDouble();
		}
		
		// 2. 계산
		for(int i=0; i<score.length; i++) {
			sum+=score[i];		// 나중에 최고,최저점수 빼주어야함
			cnt++;				// 나중에 -2 빼주어야함
		}
		
		// 3. 최고점수 구하기
		maxScore = score[0];
		maxPos = 1;
		for(int i=1; i<score.length; i++) {
			if(maxScore<score[i]) {
				maxScore = score[i];
				maxPos = i+1;
			}
		}
		
		// 4. 최저점수 구하기
		minScore = score[0];
		minPos = 1;
		for(int i=1; i<score.length; i++) {
			if(minScore>score[i]) {
				minScore = score[i];
				minPos = i+1;
			}
		}
		
		// 5. 추가 계산
		sum = sum-(maxScore+minScore);
		cnt = cnt-2;
		
		// 6. 출력하기
		System.out.printf("==> 평균점수:%.2f점\n최고점수:%.2f (심판%d)\n최저점수:%.2f (심판%d)",
								(sum/cnt), maxScore, maxPos, minScore, minPos);
		
	}
}