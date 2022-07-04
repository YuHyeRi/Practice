package guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbook_servlet/*")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	// 사용자가 요청한 주소
		GuestBookDAO dao = new GuestBookDAO();	// Dao 객체 만듦
	
		if(uri.indexOf("list.do") != -1) {	
			String searchkey = "name";			// 검색옵션 : name으로 찾기
			String search = "";					// 검색키워드 : null
			if(request.getParameter("searchkey") != null) {		// 검색옵션이 null이 아니면
				searchkey = request.getParameter("searchkey");
			} 
			if(request.getParameter("search") != null) {		// 검색키워드가 null이 아니면
				search = request.getParameter("search");
			}
			List<GuestBookDTO> items = dao.getList(searchkey, search);
			request.setAttribute("list", items);			// 방명록 리스트
			request.setAttribute("count", items.size());	// items.size() : 레코드 갯수
			request.setAttribute("searchkey", searchkey);	// 검색옵션
			request.setAttribute("search", search);			// 검색키워드	
			String url = "/guestbook/list.jsp";				
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);					// 아직 남아있으니 forward으로 출력 넘김
		} else if(uri.indexOf("insert.do") != -1) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			GuestBookDTO dto = new GuestBookDTO();
			dto.setName(name);
			dto.setEmail(email);
			dto.setPasswd(passwd);
			dto.setContent(content);
			dao.gbInsert(dto);
			String url = "/guestbook_servlet/list.do";
			response.sendRedirect(request.getContextPath() + url);
		} else if(uri.indexOf("passwd_check.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));	// 글번호
			String passwd = request.getParameter("passwd");				// 비밀번호
			boolean result = dao.passwdCheck(idx, passwd);				// 비번이 맞으면 true
			String url = "";
			if (result) {						// 비번이 맞다면
				url = "/guestbook/edit.jsp";	// 편집페이지
				GuestBookDTO dto = dao.gbDetail(idx);	// 상세내용을
				request.setAttribute("dto", dto);		// 저장
			} else {
				url = "/guestbook_servlet/list.do";
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);	// 포워딩 => 편집페이지로 이동
		} else if  (uri.indexOf("update.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			GuestBookDTO dto = new GuestBookDTO();
			dto.setIdx(idx);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPasswd(passwd);
			dto.setContent(content);
			dao.gbUpdate(dto);
			String url = "/guestbook_servlet/list.do";
			response.sendRedirect(request.getContextPath() + url);
		} else if  (uri.indexOf("delete.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.gbDelete(idx);
			String url = "/guestbook_servlet/list.do";
			response.sendRedirect(request.getContextPath() + url);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
