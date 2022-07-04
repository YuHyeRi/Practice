package javaDay3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Switch_Exam1 {
	// Integer.parseInt(String str) : 숫자형의 문자열을 인자값으로 받으면 해당값을
	// 10진수의 Integer 형으로 반환해준다. (간단히말해, String을 int로 변환해줌)
	
	 public static void main(String[] args) throws NumberFormatException, IOException {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      
	      //1.변수선언 (입력변수와 출력변수 선언하기)
	      String name, grade;
	      int kor, eng, mat, total;
	      float avg;
	      
	      //2.데이터 입력하기 
	      System.out.print("이름 : ");
	      name = in.readLine();	//콘솔창에서 입력을 받는 함수(Scanner와 같음)
	      
	      System.out.print("국어 : ");
	      kor = Integer.parseInt(in.readLine());	// String을 int로 변환
	      
	      System.out.print("영어 : ");
	      eng = Integer.parseInt(in.readLine());   
	      
	      System.out.print("수학 : ");
	      mat = Integer.parseInt(in.readLine());
	      
	      //3. 계산하기 
	      total = kor + eng + mat;
	      avg = total/3.0f;
	      
	      /*
	      if(avg>=90)        grade = "수";
	      else if(avg>=80)   grade = "우";
	      else if(avg>=70)   grade = "미";
	      else if(avg>=60)   grade = "양";
	      else            	 grade = "가";
	      */
	      
	      // switch문으로 바꾸기
	      switch((int)(avg/10)) {	// 스위치문에서는 부등호를 쓰기 어려워서 10으로 나눠서
	         case 10:
	         case 9:   grade="A"; break;
	         case 8:   grade="B"; break;
	         case 7:   grade="C"; break;
	         case 6:   grade="D"; break;
	         default:  grade="F"; 
	      }
	      
	      //4.출력
	      System.out.printf(
	            "%s 씨의 총점은 %d 이고 평균은 %.2f 등급은 %s 입니다.\n", 
	             name, total, avg, grade);
	   }
	}
