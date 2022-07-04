package com.score;

// Dto (Data Transfer Object) : 순수한 데이터객체
// Dto에서는 변수, getter.setter, 생성자(+super class), 간단한 메소드
// 여기서 메소드란 간단한 연산 정도는 가능, 데이터 저장용

public class ScoreDto {

	// 1. 변수 초기화
	private String name = "";
	private int write = 0;
	private int word = 0;
	private int ppt = 0;
	private int excel = 0;
	private int total = 0;
	private String grade = "";
	
	// 2. getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWrite() {
		return write;
	}
	public void setWrite(int write) {
		this.write = write;
	}
	public int getWord() {
		return word;
	}
	public void setWord(int word) {
		this.word = word;
	}
	public int getPpt() {
		return ppt;
	}
	public void setPpt(int ppt) {
		this.ppt = ppt;
	}
	public int getExcel() {
		return excel;
	}
	public void setExcel(int excel) {
		this.excel = excel;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// 3. super class
	public ScoreDto() {
		super();
	}
	
	// 4. 생성자 (주의! 생성자는 입력해야하는 데이터만 담는다!)
	public ScoreDto(String name, int write, int word, int ppt, int excel) {
		super();
		this.name = name;
		this.write = write;
		this.word = word;
		this.ppt = ppt;
		this.excel = excel;
	}
	
	// process 메소드 
	public void process() {
		this.total = this.write + this.word + this.ppt + this.excel;
		
		switch(this.total/200) {
		case 5 : 
		case 4 : grade = "A등급"; break;
		case 3 : grade = "B등급"; break;
		case 2 : grade = "C등급"; break;
		default : grade = "재시험요망!";
		}
	}
	
	// output 메소드
	public void output() {
		System.out.printf("%s %d %d %d %d %s\n", 
							name, write, word, ppt, excel, grade);
	}
	
}
