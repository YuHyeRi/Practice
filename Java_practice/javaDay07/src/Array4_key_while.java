

public class Array4_key_while {
	// �迭 �� key�� ���翩�� - while
	public static void main(String[] args) {
		
		int key = 59;
		int[] arr = new int[] {3,11,36,59,62,71};
		boolean flag = false;	// ã���� true, ��ã���� false;
		
		int i = 0;
		while(flag == false && i<arr.length) {
			if(arr[i] == key) {
				flag = true;
			} else {
				i+=1;
			}
		}
		if(flag == true) {
			System.out.printf("Found!\nIndex number : %d", i);
		} else {
			System.out.println("Not Found");
		}
		
	}
}