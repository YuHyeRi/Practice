package com.dictionary;

public class DictDto {
	
	// ����
	String eng = "";
	String kor = "";
	
	// getter setter
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	
	// ������
	public DictDto(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}
}
