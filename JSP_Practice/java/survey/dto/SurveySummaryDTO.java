package survey.dto;

public class SurveySummaryDTO {
	// 1. 변수선언
	private int survey_idx;		// 문제번호
	private int num;			// 응답번호
	private int sum_num;		// 응답횟수
	private double rate;		// 응답률
	
	// 2. getter, setter
	public int getSurvey_idx() {
		return survey_idx;
	}
	public void setSurvey_idx(int survey_idx) {
		this.survey_idx = survey_idx;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSum_num() {
		return sum_num;
	}
	public void setSum_num(int sum_num) {
		this.sum_num = sum_num;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	// 3. toString 오버라이드
	@Override
	public String toString() {
		return "SurveySummaryDTO [survey_idx=" + survey_idx + ", num=" + num + ", sum_num=" + sum_num + ", rate=" + rate
				+ "]";
	}
}
