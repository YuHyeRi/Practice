

public class Array4_key_For {
	// 배열 내 key값 존재여부 - for
	public static void main(String[] args) {
		
		int key = 45;
		int[] arr = new int[] {3,45,22,10,23,45};
		
		int i;
		for(i=0; i<arr.length; i++) {
			if(arr[i] == key)
				break;
		}
		
		if(arr[i] == key) {
			System.out.printf("Found!\nIndex number : %d", i);
		} else {
			System.out.println("Not Found");
		}
		
		
	}
}
