import java.util.ArrayList;
import java.util.List;

public class StreamTest {
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("desk");
		wordList.add("rainbow");
		wordList.add("assembly");
		wordList.add("app");
		wordList.add("virus");
		
		// forEach(각 데이터마다 이 구문이 실행됨)
		// forEach는 매개변수가 하나인 함수를 람다로 받도록 (+주로 출력에 사용)
		wordList.stream().forEach(s->System.out.println(s));
		System.out.println("==============");
		// filter 함수에는 조건식을 쓰고 return값이 T/F여야 함
		wordList.stream().filter(a->a.length()>=5)	// 5글자 이상만 걸러라
						 .map(a->a.toUpperCase())	// 전부 대문자로 처리하라
						 .forEach(a->System.out.println(a));;	// 여기서 출력
	}
}
