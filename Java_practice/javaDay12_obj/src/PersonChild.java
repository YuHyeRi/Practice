

public class PersonChild extends PersonParent {	// BPerson에 오류뜨는데 overriding을 해줘야함
	
	String phone = "";
	
	@Override
	void display() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(phone);
	}
	
	public PersonChild(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
}
