

public class PersonMain {
	public static void main(String[] args) {
		
		// PersonParent P1 = new PersonChild();
		// PersonParentŬ������ �߻�Ŭ������ ��ü�����Ұ�
		// �߻�Ŭ������ ��ü����� �������� ���� Ŭ����
		// ����ܰ迡�� �ۼ��ϴ� Ŭ����, �߻�޼��带 ��ӹ޴� �ʿ��� �ݵ�� �������̵�(�޼���ϼ�)�ؼ� ���!
		
		PersonParent p1 = new PersonChild("���츮", 31, "010-1234-5678");
		p1.display();
	}
}
