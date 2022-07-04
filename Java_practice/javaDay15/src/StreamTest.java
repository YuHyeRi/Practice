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
		
		// forEach(�� �����͸��� �� ������ �����)
		// forEach�� �Ű������� �ϳ��� �Լ��� ���ٷ� �޵��� (+�ַ� ��¿� ���)
		wordList.stream().forEach(s->System.out.println(s));
		System.out.println("==============");
		// filter �Լ����� ���ǽ��� ���� return���� T/F���� ��
		wordList.stream().filter(a->a.length()>=5)	// 5���� �̻� �ɷ���
						 .map(a->a.toUpperCase())	// ���� �빮�ڷ� ó���϶�
						 .forEach(a->System.out.println(a));;	// ���⼭ ���
	}
}
