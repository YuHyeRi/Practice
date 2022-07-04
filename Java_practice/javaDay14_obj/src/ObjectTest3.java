// String 클래스와 StringBuffer 클래스 사용법

public class ObjectTest3 {
	public static void main(String[] args) {
		// String 클래스 : 내용이 잘 변하지 않는 문자열을 저장하거나 내용이 작은 문자열
		// StringBuffer 클래스 : String보다 성능이 월등하다
		
		String s1;
		s1 = new String("rainbow");
		s1.charAt(0);	// String 클래스는 출력만 가능
		
		StringBuffer s2 = new StringBuffer();
		s2.append("Hello");	// 추가가능
		s2.setCharAt(0, 'Y');	// 0번째 index의 문자를 H로 변경
		System.out.println(s2);
		
		// 자바에서 코드가 실행되는데까지 걸리는 시간 측정하기
		// currentTimeMillis(); 함수 쓰는거 알아두기!
		long start = System.currentTimeMillis();	// 현재시간을 밀리초단위로
		int sum = 0;
		for(int i=0; i<=100000; i++) {
			sum+=i;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.printf("걸린시간 : %d\n", end - start);
		
		start = System.currentTimeMillis();
		for(int i=1; i<=10000; i++) {
			s1+=String.valueOf(i);		// String.valueOf : 숫자를 문자열로 전환하는 함수 
		}
		end = System.currentTimeMillis();
		System.out.printf("걸린시간 : %d\n", end - start);
		
		start = System.currentTimeMillis();
		for(int i=1; i<=10000; i++) {
			s2.append(String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.printf("걸린시간 : %d\n", end - start);
	}
}
