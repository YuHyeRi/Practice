// ����ó�� : try, catch, finally
public class ExceptionTest {
	public static void main(String[] args) {
		
		int[] a = new int[3];
		
		try {					// try : ������ �߻��� ���� �ִ� �κ�
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		} catch(Exception ex) {	// catch : ������ �߻��ϸ� �� �κ����� ó��
			// System.out.println("Error!!");
			ex.printStackTrace();	// �ַ� �̰� ����
		}
		finally {				// finally : ������ �߻��ߴ� ���ߴ� ������ ����
			System.out.println("������ �����! �������۾�");
		}
	}	// main
}	// class
