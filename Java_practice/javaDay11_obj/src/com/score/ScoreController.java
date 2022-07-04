package com.score;

import java.util.List;
import java.util.Scanner;

public class ScoreController {

	// 1. ScoreDao 클래스 객체 생성
	ScoreDao dao = new ScoreDao();
	
	// 2. getScore 메소드 --> 매개변수 2개(과목명, 과목별 만점(얘가 다름))
	public int getScore(String subject, int perfectScore) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(subject + " : ");
		int score = sc.nextInt();
		
		while(score<0 || score>perfectScore) {
			System.out.printf("error! 입력범위 초과(0~%d사이의 값을 입력)\n", perfectScore);
			System.out.println(subject + " : ");
			score = sc.nextInt();
		} return score;
	}
	
	// 3. display 메소드
	public void display() {
		System.out.println("1. 전체출력");
		System.out.println("2. 검색");
		System.out.println("3. 추가");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("0. 종료");
		System.out.println();
	}
	
	// 4. start 메소드 (실행메소드)
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {	// 무한루프
		display();
		System.out.print("선택 : ");
		int sel = sc.nextInt();
		
		switch(sel) {
		case 1 : output(); break;
		case 2 : search(); break;
		case 3 : append(); break;
		case 4 : modify(); break;
		case 5 : delete(); break;
		case 0 : System.out.println("프로그램이 종료되었습니다!"); 
				 return;		// 함수종료 (cf. break;는 switch만 빠져나감, while 종료X)
			}
		}
	}
	
	// 5. output 메소드
	public void output() {
		List<ScoreDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			list.get(i).process();
			list.get(i).output();
		}
	}
	
	
	// 6. find 메소드
	// 특정데이터 위치를 찾아서 반환하는 함수를 만듦
	int find(String name) {
		for(int i=0; i<dao.getList().size(); i++) {
			ScoreDto dto = dao.getList().get(i);
			if(dto.getName().equals(name))
				return i;
		} return -1;	// 함수의 리턴형이 int일 경우, 오류 발생시 보통 -1을 리턴함
	}					// 오류 : 문법적오류, 실행오류, 함수에서 결과를 못내는 오류 등..
	
	// 7. search 메소드
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		int pos = find(name);	// 위치값을 반환받음
		if(pos == -1) {
			System.out.println(name + "을 찾을 수 없습니다.");
			return;
		} ScoreDto dto = dao.getList().get(pos);
		dto.output();
	} 
	
	// 8. append 메소드
	public void append() {
		Scanner sc = new Scanner(System.in);
		
		ScoreDto dto = new ScoreDto();
		System.out.print("이름 : ");
		dto.setName(sc.next());
		dto.setWrite(getScore("필기", 400));		// 함수안 함수 호출하기(내부함수먼저실행)
		dto.setWord(getScore("워드", 200));
		dto.setPpt(getScore("PPT", 200));
		dto.setExcel(getScore("Excel", 200));
		dao.getList().add(dto);
	}
	
	// 9. modify 메소드
	public void modify() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 이름 : ");
		String name = sc.next();
		
		int pos = find(name);
		if(pos == -1) {
			System.out.println(name + "을 찾을 수 없습니다.");
			return;
		} ScoreDto dto = dao.getList().get(pos);	// 새로만들지 않고 이전객체에 덮어씀
		System.out.print("이름 : ");
		dto.setName(sc.next());
		dto.setWrite(getScore("필기", 400));
		dto.setWord(getScore("워드", 200));
		dto.setPpt(getScore("PPT", 200));
		dto.setExcel(getScore("Excel", 200));
	}
	
	// 10. delete 메소드
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 이름 : ");
		String name = sc.next();
		
		int pos = find(name);
		if(pos == -1) {
			System.out.println(name + "을 찾을 수 없습니다.");
			return;
		} ScoreDto dto = dao.getList().get(pos);
		dao.getList().remove(pos);
		System.out.println("삭제성공!");
	}
}
