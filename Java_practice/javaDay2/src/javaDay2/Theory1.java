package javaDay2;

import java.util.Scanner;

public class Theory1 {

	public static void main(String[] args) {
		/*
		int a = 5;
		int b = 6;
		
		System.out.printf("%d >  %d = %b%n", a, b, a>b );
		System.out.printf("%d <  %d = %b%n", a, b, a<b );
		System.out.printf("%d >= %d = %b%n", a, b, a>=b);
		System.out.printf("%d <= %d = %b%n", a, b, a<=b);
		System.out.printf("%d == %d = %b%n", a, b, a==b);
		System.out.printf("%d != %d = %b%n", a, b, a!=b);
		*/
		
		/*
		�� Ÿ�� ���� : ���� ���� (int, float, char,...)
		����Ÿ�� : ���� �ּҸ� ���� (class, �迭) (cf. �ڹٽ�ũ��Ʈ�� all ����Ÿ��)
		*/
		
		String s1 = "hello";	// hello : ���ڿ� ���ͷ�
		String s2 = "hello";	// s1�� s2�� ������ ������ ������ ����Ŵ
		
		System.out.println(s1 == s2);
		// ��, int�� ���� ����°� �°�
		// String�� ������ ����°� �ƴ�, �޸𸮸� �����ϴ����� ��� (�� �񱳴� .equals�� ��)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ܾ� : ");
		s1 = sc.next();
		
		System.out.println("�ܾ� : ");
		s2 = sc.next();
		
		System.out.printf("%s %s%n", s1, s2);
		System.out.println(s1 == s2);	// false : ���� ��
		System.out.println(s1.equals(s2));	// true : �� ��

	}
}
