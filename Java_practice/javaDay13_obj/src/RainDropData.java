
public class RainDropData {
	// 1. ����
	String cityName = "";
	int[] month = new int[6];
	float avg = 0;
	int sum = 0;
	
	// 2. ����Ʈ ������
	public RainDropData() {
		super();
	}

	// 3. ������ ==> �Է¹��� ���� (avg, sum�� ��°��̴� ����)
	public RainDropData(String cityName, int[] month) {
		super();
		this.cityName = cityName;
		this.month = month;
		process();
	}
	
	// 4. ����, ����
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public int[] getMonth() {
		return month;
	}
	
	public void setMonth(int[] month) {
		this.month = month;
	}
	
	public float getAvg() {
		return avg;
	}
	
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	public int getSum() {
		return sum;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	// 5. �޼���1 ==> sum, avg ������ ����
	public void process() {
		for(int i : month) {
			sum+=i;
		} avg = (float)sum/12;
	}

	// 6. �޼���2
	public void display() {
		System.out.printf("���ø� : %s\n��� : %.2f\n", cityName, avg);
		for(int i : month) {
			System.out.printf("%4d", i);
		}System.out.println();
		System.out.println();
	}
}
