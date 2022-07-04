import java.util.*;

public class CollectionTest {
	public static void main(String[] args) {
		//List<String> list = new Vector<String>();
		// ArrayList�� LinkedList�� List��� �������̽��� ��ӹ޾� �������
		// ArrayList���� ���ε����͸� �����ϴ� ����� �迭�� ����Ѵ�
		// LinkedList�� ������ �����͸� ������|���������� �ּ� ������� ���� �����͸� �����Ѵ�
		List<String> list = new Stack<String>();
		list.add("�÷綱");
		list.add("�ܶ�");
		list.add("��������");
		list.add("�ٶ���");
		
		System.out.println("=====================");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("*********************");
		// Iterator �������̽� - ������ �����Ѵ�.
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("++++++++++++++++++++++");
		// HashMap : ������ ��~�� ���� ����.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("red","����");	// key - value ���� �̷�
		map.put("green", "�ʷ�");
		map.put("purple", "����");
		
		System.out.println(map.get("red"));
		System.out.println("-----------------------");
		// Ű ���� ������� ����ϱ�
		Iterator<String> it2 = map.keySet().iterator();
		while(it2.hasNext()) {
			String key = it2.next();
			System.out.printf("%s %s\n", key, map.get(key));
		}
	}
}
