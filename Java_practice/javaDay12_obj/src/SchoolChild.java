

public class SchoolChild extends SchoolParent {
	// ����
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
	
	// ������ (�Է¹��� ����)
	public SchoolChild(String name, int age, String phone, String schoolName, String grade, String className) {
		super(name, age, phone);	// �θ������ ȣ��
		// ���� ȣ������ ������ super()�� ȣ��ȴ�.
		// �θ�Ŭ������ �����ڰ� 2�� ������ �� �� �ϳ��� �����ؼ� ȣ�� ����
		// Ư���� �������� ������ �⺻ �����ڸ� ȣ��
		this.schoolName = schoolName;
		this.grade = grade;
		this.className = className;
	}
	
	// super
	public SchoolChild() {
		super();	// super : �θ������ ȣ��
	}
	
	// ����Ű : ��Ʈ�� + �����̽� or source + overriding
	@Override
	public String toString() {
		String temp = String.format("%s %d %s %s %s %s", 
				getName(), age, phone, schoolName, grade, className);
		// name : �θ�Ŭ������ private ����� ������ �ȵ�
		// age : protected�� ������ ����
		// ==> �ذ��� : name�� ���ٱ����� protected�� �ٲٰų�, getName()�Լ��� ȣ���Ѵ�.
		// return "������ : " + super.toString() + " " + this.schoolName;
		// ���� toString�� ȣ���ϸ� �θ��� ��ü�� ���Դµ� �ڿ� + �ؼ� schoolName���� �������� �������̵� ��
		return temp;
	}
}