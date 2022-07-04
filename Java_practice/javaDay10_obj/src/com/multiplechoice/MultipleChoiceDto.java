package com.multiplechoice;
// Dto : Data Transfer Object
// VO
public class MultipleChoiceDto {
	// 1. 변수
	String name="", dap="", ox="";
	int score=0, cnt=0;
	
	// 2. 게터세터
	public String getName() {
		return name;}
	public void setName(String name) {
		this.name = name;}
	
	public String getDap() {
		return dap;}
	public void setDap(String dap) {
		this.dap = dap;}

	public String getOx() {
		return ox;}
	public void setOx(String ox) {
		this.ox = ox;}
	
	public int getScore() {
		return score;}
	public void setScore(int score) {
		this.score = score;}
	
	public int getCnt() {
		return cnt;}
	public void setCnt(int cnt) {
		this.cnt = cnt;}
	
	// 3. 생성자 (보통 꼭 붙여야 될 필요는 없을지도..)
	// 4. 수퍼 (생성자를 안만들면 모를까, 만든다면 super도 만들어줘라)
	public MultipleChoiceDto() {
		super();}
	
	// 생성자 : 입력용이지 출력용이 아님!
	// 변수 : 데이터입력용, 결과저장용 -> 생성자에서 초기화 하는건 입력용변수
	public MultipleChoiceDto(String name, String dap) {
		super();
		this.name = name;
		this.dap = dap;
}
}
