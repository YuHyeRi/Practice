

import java.util.Scanner;

public class Array2_temp {
	// �ְ�µ�(&�ð�), �����µ�(&�ð�), ��տµ� ���ϱ�
	public static void main(String[] args) {
		
		final int HOUR = 6;
		int temp[] = new int[HOUR];	
		int maxTemp, minTemp;
		int maxPos, minPos;
		int sum = 0;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. �Է°� �ޱ�
		for(int i=0; i<temp.length; i++) {
			System.out.printf("%d�� : ", i+1);
			temp[i] = sc.nextInt();	
		}
		
		// 2. ����ϱ�
		for(int i=0; i<temp.length; i++) {
			sum+=temp[i];
			cnt++;
		}
		
		// 3. �ְ�µ� ���ϱ�
		maxTemp = temp[0];
		maxPos = 1;
		for(int i=1; i<temp.length; i++) {
			if(maxTemp<temp[i]) {
				maxTemp = temp[i];
				maxPos = i+1;
			}
		}
		
		// 4. �����µ� ���ϱ�
		minTemp = temp[0];
		minPos = 1;
		for(int i=1; i<temp.length; i++) {
			if(minTemp>temp[i]) {
				minTemp = temp[i];
				minPos = i+1;
			}
		}
		
		// 5. ����ϱ�
		System.out.printf("�ְ�µ�:%d��(%d��)\n�����µ�:%d��(%d��)\n ==> ��տµ�:%d��", 
							maxTemp, maxPos, minTemp, minPos, (sum/cnt));
		
		
	}
}
