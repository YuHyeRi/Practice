package javaDay5;

public class String2_toInt {
	// 문자열 123을 숫자 123으로 출력하기
	public static void main(String[] args) {
		
		/*
		 num = 0;
		 0   * 10 + '1' - '0' = 1		// 1
		 1   * 10 + '2' - '0' = 12		// 10 + 2
		 12  * 10 + '3' - '0' = 123		// 120 + 3
		 123 * 10 + '4' - '0' = 1234	// 1230 + 4
		 
		 num = 0;
		 num  * 10 + '1' - '0' = 1		// num = 1
		 num  * 10 + '2' - '0' = 12		// num = 12
		 num  * 10 + '3' - '0' = 123	// num = 123
		 num  * 10 + '4' - '0' = 1234	// num = 1234
		 // 그냥 이 공식을 알고 있으면 편할 것 같음
		 */
		
		// .getClass().getName() : 데이터타입 확인
		// 최상위에서만(변수가 초기화된 후에만) 사용할 수 있음
		
		int i;
		int num = 0;
		String str = "123";
		
		for(i=0; i<str.length(); i++) {
			num = num*10 + str.charAt(i) - '0';
		} System.out.println(str);
		
	}
}
