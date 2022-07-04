package board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import board.dto.BoardCommentDTO;
import board.dto.BoardDTO;
import guestbook.GuestBookDTO;
import sqlmap.MybatisManager;

public class BoardDAO {	
	// 싱글톤 : 1개의 instance만 만들어서 쓴다
	// static : 시작부터 끝까지 메모리 상주, 1개만 생성됨
	private static BoardDAO instance;
	private BoardDAO() {}				// private : 외부에서 접근X
	public static BoardDAO getInstance() {
		if(instance == null) {			// null이면
			instance = new BoardDAO();	// 생성
		} return instance;
	}
	
	// 1
	public BoardDTO checkArticle(BoardDTO dto) {
		String writer = dto.getWriter();
		writer = writer.replace("<", "&lt;");
		writer = writer.replace(">", "&gt;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		
		String subject = dto.getSubject();
		subject = subject.replace("<", "&lt;");
		subject = subject.replace(">", "&gt;");
		subject = subject.replace("  ", "&nbsp;&nbsp;");
		
		String content = dto.getContent();
		if(content != null) {						// 내용이 null이 아니면
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace("  ", "&nbsp;&nbsp;");
		content = content.replace("\n", "<br>");
		}
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		return dto;
	}
	
	// 2 : 게시판 목록 가져오기
	// 페이지 나누기 pageStart, pageEnd
	public List<BoardDTO> list(int pageStart, int pageEnd){
		List<BoardDTO> list = null;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			Map<String, Object> map = new HashMap<>();		// 시작번호, 끝번호를 맵에 저장
			map.put("start", pageStart);
			map.put("end", pageEnd);
			list = session.selectList("board.list", map);	// 네임스페이스.아이디
			for(BoardDTO dto : list) {
				checkArticle(dto);							// 메소드 호출(태그문자, 공백문자, 줄바꿈문자 처리)
				if(dto.getFilename() != null) {				// 첨부파일이 있다면
					String filename = dto.getFilename();	// 파일이름
					// lastIndexOf(".") : 마지막에 있는 마침표
					// '마침표 + 1' 이니까 그 뒤에 확장자를 보겠다는 말!
					int start = filename.lastIndexOf(".") + 1;	
					if(start != -1) {		// 마침표가 있다면
						String ext = filename.substring(start, filename.length());	// 확장자만 뽑아내서 ext 변수
						dto.setExt(ext);	// dto에 확장자 설정
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();	// 위 이상이 없다면 mybatis 세션 종료
		}
		return list;
	}
	
	// 3
	public int count() {	// 레코드 갯수
		int result = 0;
		// try ~ with    try(객체), try절이 종료되면 finally를 작성하지 않아도 객체 자동 소멸
		try (SqlSession session = MybatisManager.getInstance().openSession()) {
			result = session.selectOne("board.count");	// board파일의 id가 count
		} catch (Exception e) {
			e.printStackTrace();
		} return result;	// 레코드 갯수 리턴
	}
	
	// 4
	public void insert(BoardDTO dto) {
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.insert("board.insert", dto);	// board파일의 id가 insert
			session.commit();						// insert, update, delete는 커밋필요
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 5 - 조회수 증가 처리
	public void plusReadCount(int num, HttpSession count_session) {			// num : 글번호
		SqlSession session = null;
		try {
			long read_time = 0;
			// 전에 읽은 글이면 세션이 만들어짐 (그 값을 가져와라)
			if(count_session.getAttribute("read_time_" + num) != null) {	// 글번호가 1번이면 read_time_1
				read_time = (long)count_session.getAttribute("read_time_" + num);
			}
			long current_time = System.currentTimeMillis();		// 시스템 현재 시각을 long타입 숫자로 저장
			session = MybatisManager.getInstance().openSession();
			if(current_time - read_time > 5*1000) {				// 현재 5초로 지정 (추후 수정 가능)
				session.update("board.plusReadCount", num);
				session.commit();	// update이니까 commit
				count_session.setAttribute("read_time_" + num, current_time);	// 세션에 해당 내용 기록(저장)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 6 - 제목 클릭 하면 상세 내용 보여주기
	public BoardDTO view(int num) {		// num : 글번호
		BoardDTO dto = null;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			dto = session.selectOne("board.view", num);	// selectOne : 레코드 1개이기 때문에 (ex. 글번호 5번을 클릭..)
			dto = checkArticle(dto);					// checkArticle : 줄바꿈처리, 태그처리, 공백처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		} return dto;
	}
	
	// 7 - 다운로드 처리
	public void plusDown(int num) {		// num : 게시물 번호
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.update("board.plusDown", num);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 8
	public String getFileName(int num) {
		String result = null;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			result = session.selectOne("board.getFileName", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return result;
	}
	
	// 9
	public void commentAdd(BoardCommentDTO dto) {
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.insert("board.commentAdd", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 10
	public BoardCommentDTO checkComment(BoardCommentDTO dto) {
		// 태그문자처리를 그대로 저장했다가 출력시 변환해주는 방법을 썼다
		String writer = dto.getWriter();						// toLowerCase() : 소문자로 변환
		if(writer.toLowerCase().indexOf("href") != -1 ||
			writer.toLowerCase().indexOf("xmp") != -1 ||
			writer.toLowerCase().indexOf("script") != -1) {
			writer = writer.replace("<", "&lt;");
			writer = writer.replace(">", "&gt;");
		}
		String content = dto.getContent();
		if(content != null) {
			if(content.toLowerCase().indexOf("href") != -1 ||
				content.toLowerCase().indexOf("xmp") != -1 ||
				content.toLowerCase().indexOf("script") != -1) {
				content = content.replace("<", "&lt;");
				content = content.replace(">", "&gt;");
			}
			content = content.replace("  ", "&nbsp;&nbsp;");
			content = content.replace("\n", "<br>");
		}
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		dto.setWriter(writer);			// 위 내용을 dto에 셋팅
		dto.setContent(content);
		return dto;
	}
	
	// 11 
	public List<BoardCommentDTO> commentList(int num) {
		List<BoardCommentDTO> list = null;
		List<BoardCommentDTO> list2 = new ArrayList<>();	// 새로운 배열 list2 리스트 생성
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			list = session.selectList("board.commentList", num);	// board.xml 파일
			for(BoardCommentDTO dto : list) {
				list2.add(checkComment(dto)); 		// 새로운 list2 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		} 
		return list2;
	}
	
	// 12
	public String passwdCheck(int num, String passwd) {
		String result = null;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("num", num);
			map.put("passwd", passwd);
			result = session.selectOne("board.pass_check", map);	// 레코드는 하나만 나와야하기 때문에 selectOne
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return result;
	} 
	
	// 13
	public void update(BoardDTO dto) {
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.update("board.update", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 14 - 삭제하기
	public void delete(int num) {					// num : 글번호
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.delete("board.delete", num);	// 레코드 삭제
			session.commit();	// update, insert, delete 시 커밋
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 15 - 답변기능 (답변에 답변이 또 달릴때, 기존의 re_step, re_level에 +1씩 update해줘야함)
	// 댓글의 순번 조정 (ref:답변그룹, re_step:순번)
	public void updateStep(int ref, int re_step) {
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("ref", ref);
			map.put("re_step", re_step);
			session.update("board.updateStep", map);	// xml
			session.commit();	// insert, update, delete
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	// 16 - 답변글 저장
	public void reply(BoardDTO dto) {		// 답변글 저장
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			session.insert("board.reply", dto);			// xml
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	// 17 - 검색, 레코드 갯수 (search_option:검색옵션, keyword:검색키워드)
	public int count(String search_option, String keyword) {
		int result = 0;
		// try(객체) : try절이 끝나면 자동소멸
		try (SqlSession session = MybatisManager.getInstance().openSession()) {
			Map<String, Object> map = new HashMap<>();
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			result = session.selectOne("board.search_count", map);	// xml
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	// 17-2
	public List<BoardDTO> searchList(String searchOption, String keyword, int start, int end) {
		List<BoardDTO> list = null;
		try(SqlSession session = MybatisManager.getInstance().openSession()) {
			Map<String, Object> map = new HashMap<>();
			map.put("search_option", searchOption);
			map.put("keyword", keyword);
			map.put("start", start);
			map.put("end", end);
			list = session.selectList("board.searchList", map);		// xml
			for(BoardDTO dto : list) {
				String writer = dto.getWriter();
				String subject = dto.getSubject();
				switch (searchOption) {
				case "all" :
					writer = writer.replace(keyword, "<span style='color:red'>" + keyword + "</span>");
					subject = subject.replace(keyword, "<span style='color:red'>" + keyword + "</span>");
					break;
				case "writer":
					writer = writer.replace(keyword, "<span style='color:red'>" + keyword + "</span>");
					break;
				case "subject":
					subject = subject.replace(keyword, "<span style='color:red'>" + keyword + "</span>");
					break;
				}
				dto.setWriter(writer);
				dto.setSubject(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}	// class 
