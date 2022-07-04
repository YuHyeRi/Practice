

public class Func8_leapYear {
	// 윤년 여부 확인
	public static boolean isLeap(int year) {
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) 
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		boolean result = isLeap(2021);
		System.out.println("첫번째 출력방법 : " + result);
		System.out.println("두번쨰 출력방법 : " + isLeap(2021));
	}
}
