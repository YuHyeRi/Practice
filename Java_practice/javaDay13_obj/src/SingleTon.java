
public class SingleTon {
	// 1. static ������ singleton ��ü ���庯��
	static SingleTon inst = null;	// SingleTon Ÿ���� inst ���� ����
	
	// 2. �����ڸ� private
	private SingleTon() {}
	
	// 3. ��ü�� �����ؼ� ��ȯ�ϴ� �����Լ�����
	public static SingleTon getInstance() {
		if(inst == null) {
			inst = new SingleTon();		// ���ȿ��� ���� ������ �� ����
		} return inst;
	}
	
	// �����ڿ� : �ٸ��������� ���� ��� ������ ������
	public int x;
	public int[] arr = new int[10];
	
}
