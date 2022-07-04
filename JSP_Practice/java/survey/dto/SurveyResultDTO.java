package survey.dto;

public class SurveyResultDTO {	// 설문 "응답내용"을 저장하는 클래스
	// 1. 변수설정
	private int answer_idx;		// 일렬번호
	private int survey_idx;		// 설문문제 번호
	private int num;			// 응답번호(1,2,3,4)
	
	// 2. getter, setter
	public int getAnswer_idx() {
		return answer_idx;
	}
	public void setAnswer_idx(int answer_idx) {
		this.answer_idx = answer_idx;
	}
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

	// 3. toString 오버라이드
	@Override
	public String toString() {
		return "SurveyResultDTO [answer_idx=" + answer_idx + ", survey_idx=" + survey_idx + ", num=" + num + "]";
	}
}
