

public class SchoolMain {
	public static void main(String[] args) {

		SchoolChild s1 = new SchoolChild();
		s1.setName("유혜리");
		s1.setAge(31);
		s1.setPhone("010-9194-7700");
		s1.setSchoolName("은행고");
		s1.setGrade("3학년");
		s1.setClassName("10반");
		
		// Person 클래스의 toString()이 호출됨 => 이름, 나이, 전화번호 
		// 부모클래스의 함수를 오버라이딩하면, 부모함수를 가리고 내꺼함수가 호출됨
		System.out.println(s1);
	}
}
