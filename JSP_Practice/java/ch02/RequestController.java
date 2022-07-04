package ch02;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch02_servlet/request.do") 				// form에 있는 주소와 일치 
public class RequestController extends HttpServlet {	// RequestController를 불러옴
	private static final long serialVersionUID = 1L;	// 자바 클래스의 버전을 지정, 별로 중요하지 않음

	// get 방식으로 실행했을 때 부르는
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");				// request.getParameter("변수명");
		int age = Integer.parseInt(request.getParameter("age"));// String으로 받은 값을 int로 변환
		String gender = request.getParameter("gender");
		String hobby = request.getParameter("hobby");
		
		// setAttribute(), getAttribute()에서 속성으로 사용 하는 값은 Object!
		Map<String, Object> map = new HashMap<String, Object>();// 해시맵 선언
		map.put("name", name);									// map("변수명",값);
		map.put("age", age);
		gender = gender.equals("남성")?"남성":"여성";
		map.put("gender", gender);
		map.put("hobby", hobby);
		
		System.out.println(map);
		request.setAttribute("map", map);						// setAttribute("변수명",값), request영역에 변수저장
		
		String page = "/ch02/requestResult2.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);	// url 정보 추출 객체
		rd.forward(request, response);								// 출력페이지로 이동
	}
	
	// post 방식으로 실행했을 때 부르는
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
