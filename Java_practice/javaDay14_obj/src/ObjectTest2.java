import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// ���� ���迡 ���� (implements Comparable �̰Ŵ� ���迣 X)
class Student extends Object implements Comparable {
	// 1. ����
	private String name = "";	// �̸�
	private int grade = 1;		// �г�
	
	// 2. g,s
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	// 3. ����Ʈ ������
	public Student() {
		super();
	}
	
	// 4. ������
	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	// 5. �������̵�
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;	// �ٿ�ĳ����(obj(�θ�)Ÿ���� student(�ڽ�)�� ��������ȯ)
		// equals �޼��尡 Object��ü�� �Ű������� �޴µ� Student��ü�� ���� ���� 
		// Object�� �ڵ� ��ĳ���� �ƴٰ� �����ο� Student stud = (Student)obj; ��� ������ϱ� 
		// �ٽ� Student ��ü�� ���� �ٿ�ĳ���� �ȴ�.
		return name.equals(s.name);	
	}
	
	@Override
	public String toString() {
		String s = String.format("%s %d", name, grade);
		return super.toString();
	}
	
	@Override
	public int compareTo(Object o) {
		Student s = (Student)o;
		return name.compareTo(s.name);
	}
}

public class ObjectTest2 {
	public static void main(String[] args) {
		
	
	Student s1 = new Student("������", 31);
	Object obj1 = s1;	// object Ÿ�Ժ��� = student ��ü
	// student -> object Ÿ������ ����ȯ ==> ��ĳ���� (������ ���)
	// s1 = obj1 ==> Error! (��ü�� student���ٰ� object�� ��ȯ, �װ� �ٽ� student�� �ٲٴ°Ŵϱ�, ���� ����ȯ)
	// ���������, �ٿ�ĳ������ ������ ����, ���󺹱� ���·θ��� �����ϴ�! 
	// ����, s1 = (Student)obj1; ==> �̷��� ��������ȯ�� ���������
	s1 = (Student)obj1;
	
	List<Student> list = new ArrayList();
	
	list.add( new Student("���¿�",  2)); // ��ĳ����
    list.add( new Student("���缮",  3));
    // list.add( new String("��켮"));
    
    for(int i=0; i<list.size(); i++) {
    	Student s = list.get(i);	// �ٿ�ĳ���� ����
    	System.out.println(s);
    }
    
    // ������ �� �� ����� �����ִ� Ư���� Ŭ���� - ���׸� �����鼭 �������̽����� ������ ���ڶ�� 
    // �̸��� Ŭ����
    // �ڹٿ��� ����ϴ� �͸��� Ŭ���� - �̸��� ����, Ŭ���� �����ϸ鼭 �ٷ� ��ü�� �����
    Comparator<Student> stComp = new Comparator<Student>() {
    	
    	// �� ���߽ÿ��� �� ������ ����.. �ȵ���̵� �����ڵ��� ���� ��
    	@Override
    	public int compare(Student o1, Student o2) {
    		// �տ����� ũ�� 0���� ū��
    		// ������ 0
    		// �ڿ��� ũ�� 0���� ������
			return o1.getName().compareTo(o2.getName());
    	}
    };
    
    list.sort(stComp);
    for(int i=0; i<list.size(); i++) {
    	Student s = list.get(i);	// �ٿ�ĳ���� ����
    	System.out.println(s);
    }
}
	
	class MyList{
		Object[] obs = new Object[10];
		int size = 0;
		
		public int size() {
			return size;
		}
		public void set(int i, Object obj) {
			if(i<0 || i>=10)	// ����
				return;
			obs[i] = obj;
		}
		public Object get(int index) {
			if(index<0 || index>=size) {
				return null;
			} return obs[index];
		}
		public void add(Object obj) {
			if(size<10) {
				obs[size] = obj;
				size++;
			}
		}
		int indexOf(Object ob) {
			for(int i=0; i<size; i++) {
				if(obs[i].equals(ob))
					return i;
			} return -1;
		}
	}
}
