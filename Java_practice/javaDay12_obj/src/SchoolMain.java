

public class SchoolMain {
	public static void main(String[] args) {

		SchoolChild s1 = new SchoolChild();
		s1.setName("������");
		s1.setAge(31);
		s1.setPhone("010-9194-7700");
		s1.setSchoolName("�����");
		s1.setGrade("3�г�");
		s1.setClassName("10��");
		
		// Person Ŭ������ toString()�� ȣ��� => �̸�, ����, ��ȭ��ȣ 
		// �θ�Ŭ������ �Լ��� �������̵��ϸ�, �θ��Լ��� ������ �����Լ��� ȣ���
		System.out.println(s1);
	}
}
