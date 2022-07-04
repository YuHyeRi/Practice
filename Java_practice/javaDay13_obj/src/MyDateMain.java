
public class MyDateMain {
	public static void main(String[] args) {
		MyDate d1 = new MyDate();
		d1.setMonth(2);
		d1.setDay(30);
		System.out.println(d1.getDay());
		
		MyDate d2 = new MyDate(2021,7,10);
		MyDate d3 = new MyDate("2021-7-11");
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
	}
}
