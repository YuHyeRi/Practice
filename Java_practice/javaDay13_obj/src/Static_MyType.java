// static : 객체를 안만들어도 변수, 메서드 사용가능
public class Static_MyType {
	public static void main(String[] args) {
	// 2. "클래스명.메서드명"을 해서 쓴다
	// 3. 객체생성해서 사용할수도 있긴하다(그치만잘안함고 생성자 자체를 private로 만들어버리면 객체생성불가)
	System.out.println(Static_MyType.toUpper("banana"));
	System.out.println(Static_MyType.toLower("APPLE"));
	}
	
	// 4. 생성자를 private로 만들어버리면 Static_MyType class를 객체로 만들지 못함!
	private Static_MyType() {
		super();
	}
	
	// 1. static 메서드이기 때문에
	public static boolean isCapital(char c) {
		if(c >= 'A' && c <= 'Z')
			return true;
		return false;
	}
		

	public static boolean isAlpha(char c) {
		if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
			return true;
		return false;
	}
		
	public static boolean isDigit(char c) {
		if(c >= '0' && c <= '9')
			return true;
		return false;
	}
		
	public static String toUpper(String s) {
		String r = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				r = r + (char)(s.charAt(i) - 32);
			} else 
				r = r + s.charAt(i);
		} return r;
	}
		
	public static String toLower(String s) {
		String r = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				r = r + (char)(s.charAt(i) + 32);
			} else
				r = r + s.charAt(i);
		} return r;
	}
}
