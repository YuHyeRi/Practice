package page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.dao.EmpDAO;
import page.dto.EmpDTO;

@WebServlet("/page_servlet/*")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = request.getRequestURL().toString();
		EmpDAO dao = new EmpDAO();
		if(url.indexOf("list.do") != -1) {
			int count = dao.empCount();			// 레코드 갯수
			int curPage = 1;					// 페이지 번호 (현재 1로 지정해둠)
			if(request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			// System.out.println("현재페이지 : " + curPage);
			Pager pager = new Pager(count, curPage);	// pager 클래스
			int start = pager.getPageBegin();
			int end = pager.getPageEnd();
			List<EmpDTO> list = dao.empList(start, end);
			request.setAttribute("list", list);			// 출력할 레코드 리스트
			request.setAttribute("page", pager);		// 페이지 정보(네비게이션)
			String page = "/page/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
