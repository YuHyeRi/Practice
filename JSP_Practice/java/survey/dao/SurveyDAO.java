package survey.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import sqlmap.MybatisManager;
import survey.dto.SurveyDTO;
import survey.dto.SurveyResultDTO;
import survey.dto.SurveySummaryDTO;

public class SurveyDAO {

	public List<SurveySummaryDTO> listSummary(int survey_idx){		// survey_idx : 문제번호
		SqlSession session = MybatisManager.getInstance().openSession();
		List<SurveySummaryDTO> items = session.selectList("survey.list_summary", survey_idx);	// selectList : 레코드가 2개 이상일경우 셀렉할 때
		session.close();	// 세션 종료 후 반납
		return items;
	}

	public void insertSurvey(SurveyResultDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("survey.insert_survey", dto);	// insert
		session.commit();								// commit (insert,update,delete 후 커밋)
		session.close();
	}
	
	public SurveyDTO viewQuestion(int survey_idx) {
		SqlSession session=MybatisManager.getInstance().openSession();
										// 네임스페이스.아이디
		SurveyDTO dto=session.selectOne("survey.view_question", survey_idx);
		session.close();
		return dto;
	}
}
