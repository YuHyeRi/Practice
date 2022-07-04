package score;

import java.util.ArrayList;
import java.util.Scanner;
	// �� ������ �׳� �ܿ���!!
public class ScoreManager {
	// ���� �迭�� ���� �ʰ� ArrayList Ŭ������ �����
	// �迭�� �����ѵ� �����͸� �߰��ϰų� �����ϰų� ������ �� �ִ� Ŭ������ ����
	// �� Ŭ������ ������ ������ �˷������ (ex. ArrayList<String> sList = new ArrayList<String>();)
	ArrayList<ScoreData> list = new ArrayList<ScoreData>();

	// �����ڸ� ���� ������ ��� �̸� �ְ� ��������
	public ScoreManager() {
		super();			// ��ӹ����� �θ������ ȣ��(Java�� �⺻������ object�� ������ ��ӹ���)

	list.add(new ScoreData("������", 150, 140, 150, 170));
	list.add(new ScoreData("������", 180, 170, 180, 130));
	list.add(new ScoreData("������", 170, 120, 110, 130));
	}
	
	public void output() {
		for(int i=0; i<list.size(); i++) {
			ScoreData s1 = list.get(i);
			System.out.printf("%s %d %d %d %d %d %s\n", 
								s1.getName(), s1.getTest1(), s1.getTest2(), 
								s1.getTest3(), s1.getTest4(), s1.getTotal(), s1.getGrade());
		}
	}
	
	public void process() {
		// ���� : 800�̻�(A), 600�̻�(B), 400�̻�(C), D��� �������
		for(int i=0; i<list.size(); i++) {
			ScoreData s1 = list.get(i);
			s1.process();
		}
	}
	
	public void append() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		
		int test1 = getScore("Test1", 200);
		int test2 = getScore("Test2", 200);
		int test3 = getScore("Test3", 200);
		int test4 = getScore("Test4", 200);
				
		ScoreData sd = new ScoreData(name, test1, test2, test3, test4);
		list.add(sd);
	}
	
	// append �Լ��� �߰��Ȱ�..!
	public int getScore(String subject, int limit) {
		Scanner sc = new Scanner(System.in);
		System.out.print(subject + " : ");
		int score = sc.nextInt();
		while(score<0 || score>limit) {
			System.out.printf("�Է¹����� �ʰ��մϴ�.(0~%d)\n", limit);
			System.out.print(subject + " : ");
			score = sc.nextInt();
		}
		return score;
	}
	
}
