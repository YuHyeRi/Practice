import java.util.*;

public class CollectionTest {
	public static void main(String[] args) {
		//List<String> list = new Vector<String>();
		// ArrayList와 LinkedList는 List라는 인터페이스를 상속받아 만들었음
		// ArrayList에서 내부데이터를 저장하는 방법은 배열을 사용한다
		// LinkedList는 내부의 데이터를 터이터|다음데이터 주소 연결고리를 만들어서 데이터를 저장한다
		List<String> list = new Stack<String>();
		list.add("시루떡");
		list.add("꿀떡");
		list.add("무지개떡");
		list.add("바람떡");
		
		System.out.println("=====================");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("*********************");
		// Iterator 인터페이스 - 언제나 지원한다.
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("++++++++++++++++++++++");
		// HashMap : 웹에서 정~말 많이 쓴다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("red","빨강");	// key - value 쌍을 이룸
		map.put("green", "초록");
		map.put("purple", "보라");
		
		System.out.println(map.get("red"));
		System.out.println("-----------------------");
		// 키 값을 순서대로 출력하기
		Iterator<String> it2 = map.keySet().iterator();
		while(it2.hasNext()) {
			String key = it2.next();
			System.out.printf("%s %s\n", key, map.get(key));
		}
	}
}
