package javaDay2;

import java.util.Scanner;

public class If_flastMoon_Extra {
		// �������� 10
	public static void main(String[] args) {
		
		int year, month, day;
	    int lastday = 28;
	    int countday = 0;
	    
	    Scanner sc = new Scanner(System.in);
	      
	    System.out.println("�⵵ : ");
	    year = sc.nextInt();
	    System.out.println("�� : ");
	    month = sc.nextInt();
	    System.out.println("�� : ");  
	    day = sc.nextInt();
	      
	     countday=day;
	     
	     if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
	         lastday=29;
	      if(month>1) countday= countday + 31;
	      if(month>2) countday= countday + lastday;
	      if(month>3) countday= countday + 31;
	      if(month>4) countday= countday + 30;
	      if(month>5) countday= countday + 31;
	      if(month>6) countday= countday + 30;
	      if(month>7) countday= countday + 31;
	      if(month>8) countday= countday + 31;
	      if(month>9) countday= countday + 30;
	      if(month>10) countday= countday + 31;
	      if(month>11) countday= countday + 30;
	      
	      System.out.printf("%d�� %d�� %d���� %d��°���Դϴ�.\n",
	            year, month, day, countday);
	}
}
