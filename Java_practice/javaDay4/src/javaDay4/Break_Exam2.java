package javaDay4;

public class Break_Exam2 {
	// ���� for�� ���������� (boolean����)
	// �� ������ true�� ����! (�״ϱ� ����Ʈ���� false)
	public static void main(String[] args) {
		
		  int i, j, k;
	      k = 1;
	      boolean flag = false; // ���º���(���־��±��)
	      // �� ������ false�� ��Ƶΰ�, ���� loop�� break������ true�� �ְ�,
	      // �ܺ� loop�� �̰� true �϶� break;�� ����!

	      for (i = 1; i <= 10; i++) {
	         for (j = 1; j <= 10; j++) {
	            System.out.printf("%3d", k);
	            k++;				
	            if (k > 47) {	// 47���� Ŀ����..
	               flag = true; // �����װ� Ʈ�簡 ��
	               // System.out.println(flag);
	               break;							// ������ ���̸� ����for�� ���߱�
	            }
	         }
	         System.out.println(); // 10�� �����ǰ� �ٹٲ�
	         
	         if (flag) {
	            break;				// ������ ���̸� ūfor�� ���߱�
	         }
	         // System.out.println(flag);
	      }
		
	}
}
