

// �߻�Ŭ����
public abstract class PersonParent {
		String name = "";
		int age = 0;
		
		// �߻�޼��� ==> ��ӹ޴� �ʿ��� �߻�޼��带 ������ ���ش� ({}������ ����)
		abstract void display();

		// getter, setter
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
}
