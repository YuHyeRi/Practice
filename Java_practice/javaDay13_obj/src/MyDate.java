
public class MyDate {
	private int year;
	private int month;
	private int day;
	
	// 생성자1
	public MyDate() {
		// this.year = 2021;
		// this.month = 7;
		// this.day = 14;
		this(2021, 7, 13);
		System.out.println("default constructor");
	}
	
	// 생성자2 - 매개변수가 3개
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		System.out.println("parameter int constructor");
	}
	
	// 생성자3 - 매개변수가 1개
		public MyDate(String date) {
			String[] s = date.split("-");
			this.year = Integer.parseInt(s[0]);
			this.month = Integer.parseInt(s[1]);
			this.day = Integer.parseInt(s[2]);
			System.out.println("parameter String constructor");
		}
	
	// getter, setter
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	// 이런식으로 setter에 조건을 넣을 수도 있음
	public void setDay(int day) {
		if(this.month != 2) {
			this.day = day;
			return;
		}
		if(day < 1 || day > 28)
			this.day = 1;
		else
			this.day = day;
	}

	@Override
	public String toString() {
		String s = String.format("%04d-%02d-%02d", year, month, day);
		// %02d : 두자리 확보 후 빈자리를 0으로 채움
		return s;
	}
}
