

public class PersonChild extends PersonParent {	// BPerson�� �����ߴµ� overriding�� �������
	
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
