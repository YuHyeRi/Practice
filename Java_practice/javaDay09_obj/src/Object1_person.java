

/*
 * 1.ĸ��ȭ 2.��� 3.�߻�ȭ 4.������ ==> ĸ���ߴ�
 */

class Person {					// 1. Person �̶�� class ����
	String name, gender;		// 2. Person class�� ���� �ִ� ������ ����
	int age;
	
	// 3. �Է��ϴ� �޼ҵ����
	void setValue(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;}
	
	// 4. ����ϴ� �޼ҵ����
	void outPut() {
		System.out.printf("%s %s %d\n", name, gender, age);}
}
// ���� �� �ϳ��� class�� 'public'�� �����ϴ�.
// public�� class���� �����̸��� �����ؾ� �Ѵ�. (public�� �ƴ� class�� �������!)
public class Object1_person {
	public static void main(String[] args) {
		
		Person p1 = new Person();	// p1 ��ü ����
		p1.setValue("A", "femal", 25);
		p1.outPut();
		
		// ��ü�迭
		Person[] p2 = new Person[3];	// �游 3�� �������� ��Ȳ(��ü�� �ּ� ���� ������)
		//p2[0] = new Person();			// ����, �̷��� ��ü�� �ϳ��ϳ� ����������
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
