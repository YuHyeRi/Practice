

public class Array4_key_while {
	// 배열 내 key값 존재여부 - while
	public static void main(String[] args) {
		
		int key = 59;
		int[] arr = new int[] {3,11,36,59,62,71};
		boolean flag = false;	// 찾으면 true, 못찾으면 false;
		
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