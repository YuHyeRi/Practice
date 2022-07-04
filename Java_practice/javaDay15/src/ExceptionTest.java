// 예외처리 : try, catch, finally
public class ExceptionTest {
	public static void main(String[] args) {
		
		int[] a = new int[3];
		
		try {					// try : 에러가 발생할 수도 있는 부분
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		} catch(Exception ex) {	// catch : 에러가 발생하면 이 부분으로 처리
			// System.out.println("Error!!");
			ex.printStackTrace();	// 주로 이걸 쓴다
		}
		finally {				// finally : 에러가 발생했던 안했던 무조건 실행
			System.out.println("무조건 실행됨! 마무리작업");
		}
	}	// main
}	// class
