
import java.util.ArrayList;
import java.util.List;

// overriding : toString, equals, compareTo 정도를 많이 씀
// sort의 경우 웹보다는 DB에서 쿼리로 많이함

public class SchoolBasic {
	public static void main(String[] args) {
//		Object obj = new Person();	// 모든 클래스는 Object를 상속받음
//		System.out.println(obj);	// = (obj.toStirng())과 같음
		
		
//		Person p2 = new Person("한소희", 20, "010-4321-4321");
//		System.out.println(p2);
		 
//		List(추상클래스로 객체생성X)는 ArrayList(그외에도 LinkedList...)의 부모클래스
//		기본적으로 부모클래스 참조는 자식클래스 참조가 항상 가능!!
		List<String> list = new ArrayList<String>();
		list.add("D");
		list.add("E");
		list.add("A");
		list.add(new String("C"));	// 원래 이렇게 써야하지만, String만 예외적으로 생략해서 쓸 수 있음
		
		// 1. pasta의 인덱스 위치 찾기
		int pos = list.indexOf("pasta");	
		System.out.println(pos);
		
		// 2. list 내용 오름차순정렬해서(알파벳이니까 알파벳 오름차순)
		list.sort(null);	
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));}	// 정렬한 내용 차례대로 출력하기
		System.out.println();
	
		List<SchoolParent> perList = new ArrayList<SchoolParent>();
		perList.add(new SchoolParent("라", 20, "010-1234-1234"));
		perList.add(new SchoolParent("나", 30, "010-1234-1234"));
		perList.add(new SchoolParent("가", 10, "010-1234-1234"));
		perList.add(new SchoolParent("라", 40, "010-1234-1234"));
		
		// 결론 : indexof를 쓰고 싶으면, equals를 overriding 하자! (index안에서 equals를 호출함)
		pos = perList.indexOf(new SchoolParent("김길동", 20, "010-1234-1234"));
		System.out.println(pos);
		
		// 데이터 비교
		String s1 = new String("김꺽정");
		String s2 = new String("임꺽정");
		// System.out.println(s1 > s2);	// 문자열이라 error (자바만안됨!)
		System.out.println(s1.compareTo(s2));	// s1 > s2 ?
		// s1 > s2  ==> >0		: 사전 순서상 뒷쪽이면	// +
		// s1 == s2  ==> 0		: 사전 순서가 같으면		// 0
		// s1 < s2  ==> <0		: 사전 순서상 앞쪽이면	// -
		
		// 결론 : sort를 쓰고 싶으면, compareTo를 overriding 하자!
		perList.sort(null);	// 객체들의 compareTo 함수를 호출하라는 뜻
		for(int i=0; i<perList.size(); i++) {
			System.out.println(perList.get(i));
		}
	}
}
