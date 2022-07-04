package memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.dao.MemoDAO;
import memo.dto.MemoDTO;

@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward : 주소그대로, 데이터를 전달/출력 
		// redirect : 주소바뀜, 처리완료 후 새로운 주소로 이동할 때
		MemoDAO dao = new MemoDAO();
		String url = request.getRequestURL().toString();	// 사용자가 요청한 주소
		if (url.indexOf("insert.do") != -1) {
			String writer = request.getParameter("writer");
			String memo = request.getParameter("memo");
			dao.insertMemo(new MemoDTO(writer, memo));
		} else if (url.indexOf("list.do") != -1) {
			String searchkey = request.getParameter("searchkey");
			if (searchkey == null || searchkey.equals(""))
			searchkey = "writer";							// 필드명을 writer로 설정
			String search = request.getParameter("search");	// 검색키워드
			if (search == null)	// 없으면
			search = "";		// 빈값으로
			List<MemoDTO> list = dao.listMemo(searchkey, search);
			request.setAttribute("list", list);				// 출력하기 위해 저장
			request.setAttribute("searchkey", searchkey);
			request.setAttribute("search", search);
			String page = "/memo/memo_list.jsp";			// 출력페이지
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.indexOf("view.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			MemoDTO dto = dao.viewMemo(idx);
			request.setAttribute("dto", dto);
			String page = "/memo/memo_view.jsp";
			RequestDispatcher rd= request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.indexOf("del.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.deleteMemo(idx);
			response.sendRedirect(request.getContextPath() + "/memo/memo.jsp");
		} else if(url.indexOf("delete_all.do") != -1) {
			String[] idx = request.getParameterValues("idx");
			if (idx != null) {
				for (int i = 0; i < idx.length; i++) {
					dao.deleteMemo(Integer.parseInt(idx[i]));
				}
			}
			response.sendRedirect(request.getContextPath() + "/memo/memo.jsp");
		} else if (url.indexOf("update.do") != -1) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String writer=request.getParameter("writer");
			String memo=request.getParameter("memo");
			MemoDTO dto = new MemoDTO();
			dto.setIdx(idx);
			dto.setWriter(writer);
			dto.setMemo(memo);
			dao.updateMemo(dto);
			response.sendRedirect(request.getContextPath() + "/memo/memo.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
