package ch02;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;

@WebServlet("/ch02_servlet/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestURL().toString() ==> URL가져와서 특정주소 가져오기
		// request.getRequestURL() : 전체 경로 가져오기
		// ex) http://localhost:8080/project/list.jsp	==> http://localhost:8080/project/list.jsp
		String url = request.getRequestURL().toString();	// 사용자가 요청한 주소
		if(url.indexOf("login.do") != -1) {					// indexOf에 내용이 없다면 -1이 출력, 그러니 url에 내용이 없다면 -1을 리턴함
			String id = request.getParameter("id");			// 사용자가 입력한 아이디를 알아냄
			String pw = request.getParameter("pw");			// 사용자가 입력한 비밀번호를 알아냄
			System.out.println(id);
			System.out.println(pw);
			
			MemberDAO dao = new MemberDAO();
			String name = dao.loginCheck(id,pw);			// 로그인 체크
			String message = "";
			String page = "";
			
			if(name != null) {								// 로그인 성공시
				message = name + "님 환영합니다 :)";
				page = "/ch02/loginSuccess.jsp";
				HttpSession session = request.getSession();	// 세선 객체 생성
				session.setAttribute("userid", id);			// 세션 변수 저장
				session.setAttribute("message", message);
			} else {										// 로그인 실패시
				message = "아이디 또는 비밀번호가 일치하지 않습니다.";
				page = "/ch02/login.jsp?message="+URLEncoder.encode(message,"utf-8");
			} System.out.println(message);
			  // response.sendRedirect : 페이지를 변경할 경우
			  // request.getContextPath() : 프로젝트(컨텍스트) Path 가져옴 
			  // ex) http://localhost:8080/project/list.jsp ==> /project
			  response.sendRedirect(request.getContextPath() + page);	// request.getContextPath() : 웹프로젝트의 식별자
		} else if(url.indexOf("logout.do") != -1) {
			HttpSession session = request.getSession();
			session.invalidate();							// session.invalidate() : 설정됨 모든 세션 값 제거
			String message = "안전하게 로그아웃 되었습니다";
			response.sendRedirect(request.getContextPath() + 
								"/ch02/login.jsp?message=" + URLEncoder.encode(message,"utf-8"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
