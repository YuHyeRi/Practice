import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 내일 시험에 나옴 (implements Comparable 이거는 시험엔 X)
class Student extends Object implements Comparable {
	// 1. 변수
	private String name = "";	// 이름
	private int grade = 1;		// 학년
	
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
	
	// 3. 디폴트 생성자
	public Student() {
		super();
	}
	
	// 4. 생성자
	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	// 5. 오버라이드
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;	// 다운캐스팅(obj(부모)타입을 student(자식)로 강제형변환)
		// equals 메서드가 Object객체를 매개변수로 받는데 Student객체가 들어가면 들어갈때 
		// Object로 자동 업캐스팅 됐다가 구현부에 Student stud = (Student)obj; 라고 써놨으니까 
		// 다시 Student 객체로 강제 다운캐스팅 된다.
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
		
	
	Student s1 = new Student("유혜리", 31);
	Object obj1 = s1;	// object 타입변수 = student 객체
	// student -> object 타입으로 형변환 ==> 업캐스팅 (언제나 허용)
	// s1 = obj1 ==> Error! (본체는 student였다가 object로 변환, 그걸 다시 student로 바꾸는거니까, 강제 형변환)
	// 결론적으로, 다운캐스팅이 가능한 경우는, 원상복구 상태로만이 가능하다! 
	// 따라서, s1 = (Student)obj1; ==> 이렇게 강제형변환을 시켜줘야함
	s1 = (Student)obj1;
	
	List<Student> list = new ArrayList();
	
	list.add( new Student("조승연",  2)); // 업캐스팅
    list.add( new Student("유재석",  3));
    // list.add( new String("김우석"));
    
    for(int i=0; i<list.size(); i++) {
    	Student s = list.get(i);	// 다운캐스팅 안함
    	System.out.println(s);
    }
    
    // 정렬할 때 두 대상을 비교해주는 특별한 클래스 - 제네릭 나오면서 인터페이스말고 별도로 비교자라는 
    // 이름의 클래스
    // 자바에서 사용하는 익명의 클래스 - 이름이 없음, 클래스 정의하면서 바로 객체를 만든다
    Comparator<Student> stComp = new Comparator<Student>() {
    	
    	// 웹 개발시에는 잘 쓰지는 않음.. 안드로이드 개발자들이 많이 씀
    	@Override
    	public int compare(Student o1, Student o2) {
    		// 앞에꺼가 크면 0보다 큰값
    		// 같으면 0
    		// 뒤에가 크면 0보다 작은값
			return o1.getName().compareTo(o2.getName());
    	}
    };
    
    list.sort(stComp);
    for(int i=0; i<list.size(); i++) {
    	Student s = list.get(i);	// 다운캐스팅 안함
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
			if(i<0 || i>=10)	// 오류
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
