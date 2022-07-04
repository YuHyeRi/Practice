package javaDay6;

import java.util.Scanner;

public interface Array3_overflow1underflow_QQ {
	// 입력값(방향, 회전횟수) 넣고 배열의 데이터 회전하기
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a[] = new int[] {1,2,3,4,5,6,7,8,9};
		int i, k;
		int overFlow, underFlow;
		
		System.out.print("방향 (L:Left, R:Right) : ");
		String direct = sc.next();
		System.out.print("회전횟수 : ");
		int rotateCnt = sc.nextInt();
		
		if(direct.equals("L") || direct.equals("l")) {
			for(k=1; k<=rotateCnt; k++) {	// 입력된 회전수만큼 반복할건데
				overFlow = a[0];			// 0번쨰 인덱스에 있는거 일단 담아
				for(i=1; i<a.length; i++) {	// 1부터 시작하고
					a[i-1] = a[i];			// 한칸씩 왼쪽으로 땡겨
				} a[a.length-1] = overFlow; // 아까 담았던거 맨 끝에다가 놔
			}
		}
		else {
			for(k=1; k<=rotateCnt; k++) {
				underFlow = a[a.length-1];	// 맨 끝 인덱스에 있는거 일단 담아
				for(i=a.length-1; i>0; i--) {	// a.length-1 : 마지막 방(번호)
					a[i] = a[i-1];			// 한칸씩 오른쪽으로 땡겨
				} a[0] = underFlow;			// 아까 담았던거 맨 앞에다 놔
			}
		}
		for(i=0; i<a.length; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
		
		
	}
}
