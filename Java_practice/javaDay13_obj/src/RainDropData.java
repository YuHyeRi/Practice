
public class RainDropData {
	// 1. 변수
	String cityName = "";
	int[] month = new int[6];
	float avg = 0;
	int sum = 0;
	
	// 2. 디폴트 생성자
	public RainDropData() {
		super();
	}

	// 3. 생성자 ==> 입력받을 값만 (avg, sum은 출력값이니 제외)
	public RainDropData(String cityName, int[] month) {
		super();
		this.cityName = cityName;
		this.month = month;
		process();
	}
	
	// 4. 게터, 세터
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
	
	// 5. 메서드1 ==> sum, avg 간단한 연산
	public void process() {
		for(int i : month) {
			sum+=i;
		} avg = (float)sum/12;
	}

	// 6. 메서드2
	public void display() {
		System.out.printf("도시명 : %s\n평균 : %.2f\n", cityName, avg);
		for(int i : month) {
			System.out.printf("%4d", i);
		}System.out.println();
		System.out.println();
	}
}
