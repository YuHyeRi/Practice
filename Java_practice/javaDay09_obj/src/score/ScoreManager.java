package score;

import java.util.ArrayList;
import java.util.Scanner;
	// 이 구조는 그냥 외우자!!
public class ScoreManager {
	// 보통 배열은 쓰지 않고 ArrayList 클래스를 사용함
	// 배열과 유사한데 데이터를 추가하거나 수정하거나 삭제할 수 있는 클래스라 편리함
	// 이 클래스에 무엇을 담을지 알려줘야함 (ex. ArrayList<String> sList = new ArrayList<String>();)
	ArrayList<ScoreData> list = new ArrayList<ScoreData>();

	// 생성자를 만들어서 데이터 몇개를 미리 넣고 시작하자
	public ScoreManager() {
		super();			// 상속받으면 부모생성자 호출(Java는 기본적으로 object를 무조건 상속받음)

	list.add(new ScoreData("아이유", 150, 140, 150, 170));
	list.add(new ScoreData("유혜리", 180, 170, 180, 130));
	list.add(new ScoreData("이진우", 170, 120, 110, 130));
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
		// 총점 : 800이상(A), 600이상(B), 400이상(C), D등급 재시험요망
		for(int i=0; i<list.size(); i++) {
			ScoreData s1 = list.get(i);
			s1.process();
		}
	}
	
	public void append() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		
		int test1 = getScore("Test1", 200);
		int test2 = getScore("Test2", 200);
		int test3 = getScore("Test3", 200);
		int test4 = getScore("Test4", 200);
				
		ScoreData sd = new ScoreData(name, test1, test2, test3, test4);
		list.add(sd);
	}
	
	// append 함수에 추가된것..!
	public int getScore(String subject, int limit) {
		Scanner sc = new Scanner(System.in);
		System.out.print(subject + " : ");
		int score = sc.nextInt();
		while(score<0 || score>limit) {
			System.out.printf("입력범위를 초과합니다.(0~%d)\n", limit);
			System.out.print(subject + " : ");
			score = sc.nextInt();
		}
		return score;
	}
	
}
