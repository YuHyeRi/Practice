package common;

import javax.servlet.http.Cookie;

public class Util {

	public static String getCookie(Cookie[] cookies, String name) {
		String result = "";
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals(name)) {
					result = cookies[i].getValue();
					break;		// 반복문 종료
				}
			}
		}
		return result;
	}
}
