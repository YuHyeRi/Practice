
public class MyDatePerson {
	private String name = "";
	private int age = 31;
	private MyDate birthday = new MyDate(1991,9,23);
	
	// 持失切1
	public MyDatePerson() {}
	
	// 持失切2
	public MyDatePerson(String name, int age, MyDate birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
}
