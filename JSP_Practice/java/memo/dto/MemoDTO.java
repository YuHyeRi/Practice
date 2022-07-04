package memo.dto;

public class MemoDTO {
	// 1. 변수선언
	private int idx;
	private String writer;
	private String memo;
	private String post_date;
	
	// 2. getter, setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	
	// 3. toString 오버라이드
	@Override
	public String toString() {
		return "MemoDTO [idx=" + idx + ", writer=" + writer + ", memo=" + memo + ", post_date=" + post_date + "]";
	}
	
	// 4. 디폴트 생성자
	public MemoDTO() {
	}
	
	// 5. 매개변수 있는 생성자 (입력할 것만)
	public MemoDTO(String writer, String memo) {
		super();
		this.writer = writer;
		this.memo = memo;
	}
}
