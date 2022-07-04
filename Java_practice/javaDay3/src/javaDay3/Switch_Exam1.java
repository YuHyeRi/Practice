package javaDay3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Switch_Exam1 {
	// Integer.parseInt(String str) : �������� ���ڿ��� ���ڰ����� ������ �ش簪��
	// 10������ Integer ������ ��ȯ���ش�. (����������, String�� int�� ��ȯ����)
	
	 public static void main(String[] args) throws NumberFormatException, IOException {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      
	      //1.�������� (�Էº����� ��º��� �����ϱ�)
	      String name, grade;
	      int kor, eng, mat, total;
	      float avg;
	      
	      //2.������ �Է��ϱ� 
	      System.out.print("�̸� : ");
	      name = in.readLine();	//�ܼ�â���� �Է��� �޴� �Լ�(Scanner�� ����)
	      
	      System.out.print("���� : ");
	      kor = Integer.parseInt(in.readLine());	// String�� int�� ��ȯ
	      
	      System.out.print("���� : ");
	      eng = Integer.parseInt(in.readLine());   
	      
	      System.out.print("���� : ");
	      mat = Integer.parseInt(in.readLine());
	      
	      //3. ����ϱ� 
	      total = kor + eng + mat;
	      avg = total/3.0f;
	      
	      /*
	      if(avg>=90)        grade = "��";
	      else if(avg>=80)   grade = "��";
	      else if(avg>=70)   grade = "��";
	      else if(avg>=60)   grade = "��";
	      else            	 grade = "��";
	      */
	      
	      // switch������ �ٲٱ�
	      switch((int)(avg/10)) {	// ����ġ�������� �ε�ȣ�� ���� ������� 10���� ������
	         case 10:
	         case 9:   grade="A"; break;
	         case 8:   grade="B"; break;
	         case 7:   grade="C"; break;
	         case 6:   grade="D"; break;
	         default:  grade="F"; 
	      }
	      
	      //4.���
	      System.out.printf(
	            "%s ���� ������ %d �̰� ����� %.2f ����� %s �Դϴ�.\n", 
	             name, total, avg, grade);
	   }
	}
