

public class CalculatorMain {
	
	public static void main(String[] args) {
		
		Calculator c1 = new CalculatorImpl();
		
		System.out.println(c1.add(2, 2));
		System.out.println(c1.sub(4, 2));
		System.out.println(c1.mul(3, 2));
		System.out.println(c1.div(2, 2));
	}
}
