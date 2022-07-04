package member;

public class MemberDTO {
	// 1. 변수
	private String userid;
	private String passwd;
	private String name;
	
	// 2. getter, setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 3. 디폴트 생성자
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 4. 매개변수가 있는 생성자
	public MemberDTO(String userid, String passwd, String name) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
	}
	
	// 5. 오버라이드
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + "]";
	}
}
