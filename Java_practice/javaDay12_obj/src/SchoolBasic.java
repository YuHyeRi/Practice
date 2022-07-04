
import java.util.ArrayList;
import java.util.List;

// overriding : toString, equals, compareTo ������ ���� ��
// sort�� ��� �����ٴ� DB���� ������ ������

public class SchoolBasic {
	public static void main(String[] args) {
//		Object obj = new Person();	// ��� Ŭ������ Object�� ��ӹ���
//		System.out.println(obj);	// = (obj.toStirng())�� ����
		
		
//		Person p2 = new Person("�Ѽ���", 20, "010-4321-4321");
//		System.out.println(p2);
		 
//		List(�߻�Ŭ������ ��ü����X)�� ArrayList(�׿ܿ��� LinkedList...)�� �θ�Ŭ����
//		�⺻������ �θ�Ŭ���� ������ �ڽ�Ŭ���� ������ �׻� ����!!
		List<String> list = new ArrayList<String>();
		list.add("D");
		list.add("E");
		list.add("A");
		list.add(new String("C"));	// ���� �̷��� ���������, String�� ���������� �����ؼ� �� �� ����
		
		// 1. pasta�� �ε��� ��ġ ã��
		int pos = list.indexOf("pasta");	
		System.out.println(pos);
		
		// 2. list ���� �������������ؼ�(���ĺ��̴ϱ� ���ĺ� ��������)
		list.sort(null);	
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));}	// ������ ���� ���ʴ�� ����ϱ�
		System.out.println();
	
		List<SchoolParent> perList = new ArrayList<SchoolParent>();
		perList.add(new SchoolParent("��", 20, "010-1234-1234"));
		perList.add(new SchoolParent("��", 30, "010-1234-1234"));
		perList.add(new SchoolParent("��", 10, "010-1234-1234"));
		perList.add(new SchoolParent("��", 40, "010-1234-1234"));
		
		// ��� : indexof�� ���� ������, equals�� overriding ����! (index�ȿ��� equals�� ȣ����)
		pos = perList.indexOf(new SchoolParent("��浿", 20, "010-1234-1234"));
		System.out.println(pos);
		
		// ������ ��
		String s1 = new String("�販��");
		String s2 = new String("�Ӳ���");
		// System.out.println(s1 > s2);	// ���ڿ��̶� error (�ڹٸ��ȵ�!)
		System.out.println(s1.compareTo(s2));	// s1 > s2 ?
		// s1 > s2  ==> >0		: ���� ������ �����̸�	// +
		// s1 == s2  ==> 0		: ���� ������ ������		// 0
		// s1 < s2  ==> <0		: ���� ������ �����̸�	// -
		
		// ��� : sort�� ���� ������, compareTo�� overriding ����!
		perList.sort(null);	// ��ü���� compareTo �Լ��� ȣ���϶�� ��
		for(int i=0; i<perList.size(); i++) {
			System.out.println(perList.get(i));
		}
	}
}
