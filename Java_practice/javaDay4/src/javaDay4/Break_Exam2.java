package javaDay4;

public class Break_Exam2 {
	// 이중 for문 빠져나가기 (boolean쓰기)
	// 이 조건이 true면 멈춰! (그니까 디폴트값은 false)
	public static void main(String[] args) {
		
		  int i, j, k;
	      k = 1;
	      boolean flag = false; // 상태변수(자주쓰는기법)
	      // 이 변수에 false를 담아두고, 내부 loop가 break했을때 true를 넣고,
	      // 외부 loop는 이게 true 일때 break;를 하자!

	      for (i = 1; i <= 10; i++) {
	         for (j = 1; j <= 10; j++) {
	            System.out.printf("%3d", k);
	            k++;				
	            if (k > 47) {	// 47보다 커지면..
	               flag = true; // 프래그가 트루가 됨
	               // System.out.println(flag);
	               break;							// 조건이 참이면 작은for문 멈추기
	            }
	         }
	         System.out.println(); // 10씩 나열되고 줄바꿈
	         
	         if (flag) {
	            break;				// 조건이 참이면 큰for문 멈추기
	         }
	         // System.out.println(flag);
	      }
		
	}
}
