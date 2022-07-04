package survey;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.dao.SurveyDAO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyResultDTO;
import survey.dto.SurveySummaryDTO;

/**
 * : 모든 키워드가 허용 (때문에, 404에러가 안뜸!) 현재 우리가 액션을 3개를 만들었기 때문에, *을 써야 한다. (하나만 콕 찝어서
 * 넣으면 파일을 3개로 만들어야 하기 때문에..!)
 */
@WebServlet("/survey_servlet/*")	// index의 survey_survlet 와 일치해야함
public class SurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getContextPath();		// getContextPath : 컨텍스트 패스
		String url = request.getRequestURI();		// getRequestURI : 사용자가 요청한 주소
		SurveyDAO dao = new SurveyDAO();
		
		if(url.indexOf("input.do") != -1) {			// input.do가 있으면
			SurveyDTO dto = dao.viewQuestion(1);	// 1번 문제 불러오기
			System.out.println("dto:" + dto);
			request.setAttribute("dto", dto);		// 값 저장해서
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_input.jsp");	// 출력페이지로
			rd.forward(request, response);			// 포워드
		} else if(url.indexOf("insert.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));	// survey_idx : 문제번호 (String -> int)
			int num = Integer.parseInt(request.getParameter("num"));	// num : 응답번호
			SurveyResultDTO dto = new SurveyResultDTO();
			dto.setSurvey_idx(survey_idx);
			dto.setNum(num);
			dao.insertSurvey(dto);	// 응답내용(레코드) 저장
			response.sendRedirect(path + "/survey/input_result.jsp");	// redirect : 작업끝, 새로운 url로 이동할때, 자료삭제됨
		} else if(url.indexOf("survey_result.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			List<SurveySummaryDTO> items = dao.listSummary(survey_idx);
			request.setAttribute("list", items);
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_result.jsp");	// 출력페이지로 포워드
			rd.forward(request, response);	// forward : 이어지는 작업, url도 안바뀜, 자료유지됨
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
