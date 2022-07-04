

public class SchoolChild extends SchoolParent {
	// 변수
	public String schoolName = "";
	public String grade = "";
	public String className = "";
	
	// getter, setter
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	// 생성자 (입력받을 값만)
	public SchoolChild(String name, int age, String phone, String schoolName, String grade, String className) {
		super(name, age, phone);	// 부모생성자 호출
		// 직접 호출하지 않으면 super()가 호출된다.
		// 부모클래스에 생성자가 2개 있으면 둘 중 하나를 선택해서 호출 가능
		// 특별히 선택하지 않으면 기본 생성자를 호출
		this.schoolName = schoolName;
		this.grade = grade;
		this.className = className;
	}
	
	// super
	public SchoolChild() {
		super();	// super : 부모생성자 호출
	}
	
	// 단축키 : 컨트롤 + 스페이스 or source + overriding
	@Override
	public String toString() {
		String temp = String.format("%s %d %s %s %s %s", 
				getName(), age, phone, schoolName, grade, className);
		// name : 부모클래스의 private 멤버라 접근이 안됨
		// age : protected라 접근이 가능
		// ==> 해결방법 : name의 접근권한을 protected로 바꾸거나, getName()함수를 호출한다.
		// return "데이터 : " + super.toString() + " " + this.schoolName;
		// 원래 toString을 호출하면 부모의 객체만 나왔는데 뒤에 + 해서 schoolName까지 나오도록 오버라이딩 함
		return temp;
	}
}