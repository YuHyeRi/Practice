

import java.util.Scanner;

public class CharAt_correct {
	// ä�� �� ���� ����ϱ�
	public static void main(String[] args) {

		final String JUNGDAP = "1234567890";	// �����̴ϱ� ����� ������ ��
		String name;
		String answer;
		String result = "";
		int score;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. �Է°� �ޱ�
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.println("�ۼ��� ���� �Է��ϼ���.");
		answer = sc.nextLine();
		
		// 2. ���ϱ�
		int i = 0;
		for(i=0; i<answer.length(); i++) {
			if(answer.charAt(i) == JUNGDAP.charAt(i)) {
				result += "O";
				cnt++;
			} else {
				result += "X";
			}
		} 
		
		// 3. ���� ����ϱ� (������ 10��)
		score = cnt * 10;
		
		// 4. ����ϱ�
		System.out.println(result);
		System.out.printf("�������� => %d��\n���� => %d��", cnt, score);

		
	}
}