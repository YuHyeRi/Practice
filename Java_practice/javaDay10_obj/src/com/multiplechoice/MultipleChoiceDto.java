package com.multiplechoice;
// Dto : Data Transfer Object
// VO
public class MultipleChoiceDto {
	// 1. ����
	String name="", dap="", ox="";
	int score=0, cnt=0;
	
	// 2. ���ͼ���
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
	
	// 3. ������ (���� �� �ٿ��� �� �ʿ�� ��������..)
	// 4. ���� (�����ڸ� �ȸ���� �𸦱�, ����ٸ� super�� ��������)
	public MultipleChoiceDto() {
		super();}
	
	// ������ : �Է¿����� ��¿��� �ƴ�!
	// ���� : �������Է¿�, �������� -> �����ڿ��� �ʱ�ȭ �ϴ°� �Է¿뺯��
	public MultipleChoiceDto(String name, String dap) {
		super();
		this.name = name;
		this.dap = dap;
}
}
