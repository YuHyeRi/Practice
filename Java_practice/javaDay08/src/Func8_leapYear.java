

public class Func8_leapYear {
	// ���� ���� Ȯ��
	public static boolean isLeap(int year) {
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) 
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		boolean result = isLeap(2021);
		System.out.println("ù��° ��¹�� : " + result);
		System.out.println("�ι��� ��¹�� : " + isLeap(2021));
	}
}
