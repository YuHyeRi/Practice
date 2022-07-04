package ch01;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션
@WebServlet("/ch01_servlet/while.do")
public class WhileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WhileController() {
        super(); 
    }

    // 1. get 방식으로 호출할 때 실행되는 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));	// 폼의 입력값을 숫자로 변환
		int num = Integer.parseInt(request.getParameter("num"));
		int result = 1;
		
		for(int i=1; i<=num; i++) {
			result *= number;
		}
		request.setAttribute("result", result);		// setAttribute(key,value) 변수저장
		RequestDispatcher rd = request.getRequestDispatcher("/ch01/whileResult.jsp");
		rd.forward(request, response);				// 출력 페이지로 이동하여 결과 출력
	}

	// 2. post 방식으로 호출할 때 실행되는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
