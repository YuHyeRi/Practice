

/*
 * 1.캡슐화 2.상속 3.추상화 4.다형성 ==> 캡상추다
 */

class Person {					// 1. Person 이라는 class 생성
	String name, gender;		// 2. Person class와 관련 있는 변수들 선언
	int age;
	
	// 3. 입력하는 메소드생성
	void setValue(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;}
	
	// 4. 출력하는 메소드생성
	void outPut() {
		System.out.printf("%s %s %d\n", name, gender, age);}
}
// 파일 내 하나의 class만 'public'이 가능하다.
// public인 class명은 파일이름과 동일해야 한다. (public이 아닌 class는 상관없음!)
public class Object1_person {
	public static void main(String[] args) {
		
		Person p1 = new Person();	// p1 객체 생성
		p1.setValue("A", "femal", 25);
		p1.outPut();
		
		// 객체배열
		Person[] p2 = new Person[3];	// 방만 3개 만들어놓은 상황(객체의 주소 저장 공간만)
		//p2[0] = new Person();			// 따라서, 이렇게 객체를 하나하나 만들어줘야함
		//p2[1] = new Person();
		//p2[2] = new Person();
		for(int i=0; i<p2.length; i++) {
			p2[i] = new Person();}
		
		p2[0].setValue("A1", "male", 30);
		p2[1].setValue("A2", "female", 25);
		p2[2].setValue("A3", "male", 32);
		
		//p2[0].outPut();
		//p2[0].outPut();
		//p2[0].outPut();
		for(int i=0; i<p2.length; i++) {
			p2[i].outPut();}
		
	}
}
