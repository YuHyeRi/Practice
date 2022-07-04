

public class SchoolParent implements Comparable {
	
	// ����
	private String name = "";	// private : ���� Ŭ���������� ��밡��
	protected int age = 0;		// �θ��ڽİ����� public, �ܺο����� private
	public String phone = "";
	
	// Getter, Setter
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// super
	public SchoolParent() {
		super();
	}
	
	// ������
	public SchoolParent(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	@Override			
	public String toString() {
	// System.out.println("�������̵� ��!");	// �������̵�(�߰�)�� ����
	// return super.toString();				// ���� �θ� Ŭ������ �ִ� �Լ��� ȣ���ϰڴ�
	   return name + " " + age + " " + phone + " ";	// �̷��� �θ� ����� �������̵��� ����
	}
	
	// ȫ�浿	-> ������� ����� ��	(�ڽ�Ÿ�� -> �θ�Ÿ�� (=> ��ĳ����, �ö󰡴� ����ȯ, always ���))
	// ���	-> ȫ�浿���� ����		(�θ�Ÿ�� -> �ڽ�Ÿ�� (=> �ٿ�ĳ����, �������� ����ȯ, ��Ģ������ ���X))
	// ���������� �ڽ�Ÿ�� -> �θ�Ÿ�� -> �ڽ�Ÿ��(���󺹱�) => ���
	
	@Override
	// Person -> Object -> Person
	public boolean equals(Object obj) {	// object�� p2
		SchoolParent temp = (SchoolParent)obj;	// ���� �ٿ�ĳ����
		// return super.equals(obj);
		return name.equals(temp.name);
		// ��name : ȫ�浿~��浿���ư��鼭 ��, ��temp.name : ã������ '�ڱ浿' 
	}
	
	@Override
	// �̸��� ���ؼ� �����ϱ�
	public int compareTo(Object obj) {
		SchoolParent temp = (SchoolParent) obj;
		return name.compareTo(temp.name);
	}
}

