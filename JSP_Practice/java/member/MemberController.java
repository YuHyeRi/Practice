package member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = request.getRequestURI();
	String context = request.getContextPath();	// 컨텍스트 패스
	MemberDAO dao = new MemberDAO();			// dao 객체
	
	if(url.indexOf("list.do") != -1) {			// 회원리스트
		Map<String, Object> map = new HashMap<String, Object>();	// 해시맵 생성
		List<MemberDTO> list = dao.memberList();	// 회원리스트
		map.put("list", list);						// map에 저장
		map.put("count", list.size());				// 리스트의 갯수
		request.setAttribute("map", map);			// request영역에 저장
		String page = "/ch06/member_list.jsp";		// 출력페이지
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);				// 출력페이지로 이동
		} else if (url.indexOf("join.do") != -1) {	// join ==> 내용 입력후 추가버튼 누르면 리스트 추가됨
			// member.jsp에서 넘어온 값들을 dto에 저장
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			MemberDTO dto = new MemberDTO(userid, passwd, name, address, tel);	// 1. 5개의 값을 따로따로 전달하는 방법
			dao.insert(dto);													// 2. dto에 묶어서 한번에 보내는 방법
		} else if(url.indexOf("view.do") != -1) {
			String userid = request.getParameter("userid");
			System.out.println("view.do, userid : " + userid);
			MemberDTO dto = dao.memberDetail(userid);
			request.setAttribute("dto", dto);
			String page = "/ch06/member_view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("update.do") != -1) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			MemberDTO dto = new MemberDTO(userid, passwd, name, address, tel);
			dao.update(dto);
			response.sendRedirect(context + "/ch06/member.jsp");	// 페이지이동
			// forward : 데이터를 보내서 출력
			// sendRedirect : context(21번째 줄에 정의해둠) 주소를 꼭 적어주어야 한다
		} else if (url.indexOf("delete.do") != -1) {
			String userid = request.getParameter("userid");			// 삭제할 아이디 (히든태그로 아이디가 넘어옴)
			dao.delete(userid);			// 레코드 삭제
			response.sendRedirect(context + "/ch06/member.jsp");	// 삭제후 다시 목록으로 이동시킴 (member.jsp)
		} else if (url.indexOf("login.do") != -1) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			MemberDTO dto = new MemberDTO();
			dto.setUserid(userid);
			dto.setPasswd(passwd);
			String result = dao.loginCheck(dto);
			request.setAttribute("result", result);
			String page = "/ch06/login_result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}  else if (url.indexOf("join_oracle_secret.do") != -1) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			MemberDTO dto = new MemberDTO();
			dto.setUserid(userid);
			dto.setPasswd(passwd);
			dto.setName(name);
			dao.insertCrypt(dto);	
		} else if (url.indexOf("login_oracle_secret.do") != -1) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			MemberDTO dto = new MemberDTO();
			dto.setUserid(userid);
			dto.setPasswd(passwd);
			String result = dao.loginCheckCrypt(dto);
			request.setAttribute("result", result);
			String page = "/ch06/login_result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	
	
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
