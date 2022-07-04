

import java.util.Scanner;

public class Array3_score {
	// �������, �ְ�����(&���ǹ�ȣ), ��������(&���ǹ�ȣ) ���ϱ�
	// ��, ��������� �ְ����� �� �������� ������ ���
	public static void main(String[] args) {
		
		final int SIMPAN = 5;	// ���� �ο���
		double score[] = new double[SIMPAN];
		double maxScore, minScore;
		double sum = 0;
		int cnt = 0;
		int maxPos, minPos;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. �Է°� �ޱ�
		for(int i=0; i<score.length; i++) {
			System.out.printf("���� %d : ", i+1);
			score[i] = sc.nextDouble();
		}
		
		// 2. ���
		for(int i=0; i<score.length; i++) {
			sum+=score[i];		// ���߿� �ְ�,�������� ���־����
			cnt++;				// ���߿� -2 ���־����
		}
		
		// 3. �ְ����� ���ϱ�
		maxScore = score[0];
		maxPos = 1;
		for(int i=1; i<score.length; i++) {
			if(maxScore<score[i]) {
				maxScore = score[i];
				maxPos = i+1;
			}
		}
		
		// 4. �������� ���ϱ�
		minScore = score[0];
		minPos = 1;
		for(int i=1; i<score.length; i++) {
			if(minScore>score[i]) {
				minScore = score[i];
				minPos = i+1;
			}
		}
		
		// 5. �߰� ���
		sum = sum-(maxScore+minScore);
		cnt = cnt-2;
		
		// 6. ����ϱ�
		System.out.printf("==> �������:%.2f��\n�ְ�����:%.2f (����%d)\n��������:%.2f (����%d)",
								(sum/cnt), maxScore, maxPos, minScore, minPos);
		
	}
}