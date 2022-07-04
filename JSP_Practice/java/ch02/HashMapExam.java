package ch02;

import java.util.HashMap;
import java.util.Map;

public class HashMapExam {
	public static void main(String[] args) {
		// 컨트롤 + 쉬프트 + O
		// Map<key자료형, value자료형>
		Map<String, Object> map = new HashMap<String, Object>();	// object : 모든값을 담을 수 있다
		// map.put("a", "10");
		// map.put("b", 100);
		// map.put("c", true);
		map.put("name", "아이유");		// put : 자료입력
		map.put("hobby", "노래");			// ※ 단, 순서는 섞인다 (차례대로 출력X)
		map.put("age", 28);
		map.put("gender", "여성");
		// System.out.println(map);		// {gender=남성, name=김철수, age=25, hobby=등산}
		String n = (String)map.get("name");	// (자료형)map.get("변수명")
		int a = (int)map.get("age");
		String h = (String)map.get("hobby");
		System.out.println("이름:" + n + " 나이:" + a + " 취미:" + h);
	}
}
