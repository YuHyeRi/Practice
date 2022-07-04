package score;
// public O ==> ���� ��Ű���� �ٸ� Ŭ�������� ��� ����
// public X ==> ���� ��Ű���� �ٸ� Ŭ�������� ��� �Ұ���
// getter(���� �а�) setter(���� ����) ��� ������ ���ؼ� �Լ��� ������־�� ��
public class ScoreData {
	// 1. ����(�ѻ����)
	private String name = "";
	private int test1 = 0;
	private int test2 = 0;
	private int test3 = 0;
	private int test4 = 0;
	private int total = 0;
	private String grade = "";
	
	// 2. ���ͼ���
	public String getName() {
		return name;}

	public void setName(String name) {
		this.name = name;}

	public int getTest1() {
		return test1;}

	public void setTest1(int test1) {
		this.test1 = test1;}

	public int getTest2() {
		return test2;}

	public void setTest2(int test2) {
		this.test2 = test2;}

	public int getTest3() {
		return test3;}

	public void setTest3(int test3) {
		this.test3 = test3;}

	public int getTest4() {
		return test4;}

	public void setTest4(int test4) {
		this.test4 = test4;}

	public int getTotal() {
		return total;}

	public void setTotal(int total) {
		this.total = total;}

	public String getGrade() {
		return grade;}

	public void setGrade(String grade) {
		this.grade = grade;}

	// 3. ������
	public ScoreData(String name, int test1, int test2, int test3, int test4) {
		super();
		this.name = name;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;}

	// 4. ���� (�� ��쿣 ��������)
	public ScoreData() {
		super();}

	// �Լ��� �Ѱ��� ��ɿ��� ��������!
	public void process() {
		this.total =  test1 + test2 + test3 + test4;
		switch(total/200) {
		case 4 : grade = "A���"; break;
		case 3 : grade = "B���"; break;
		case 2 : grade = "C���"; break;
		default : grade = "�������!";}
	}


}
