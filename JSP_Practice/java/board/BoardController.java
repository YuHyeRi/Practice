package board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDAO;
import board.dto.BoardCommentDTO;
import board.dto.BoardDTO;
import common.Constants;
import page.Pager;

@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();	// 사용자가 요청한 주소
		String contextPath = request.getContextPath();		// 컨텍스트 패스
		BoardDAO dao = BoardDAO.getInstance();				// dao 생성 (dao 생성자가 private이니까 new로 만들수 X)
		
		if(url.indexOf("list.do") != -1) {
			int count = dao.count();			// 레코드 갯수 계산
			int curPage = 1;					// 현재 페이지 번호 (1페이지 부터~)
			if(request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			Pager pager = new Pager(count, curPage);
			int start = pager.getPageBegin();	// 페이지의 레코드 시작번호	--> xml의 #{start}
			int end = pager.getPageEnd();		// 페이지의 레코드 마지막번호  --> xml의 #{end}
			List<BoardDTO> list = dao.list(start, end);	// 페이지의 레코드 리스트
			request.setAttribute("list", list);		// 출력전, 자료저장
			request.setAttribute("page", pager);	// 출력전, 자료저장
			String page = "/board/list.jsp";		// 출력페이지로 포워드
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("insert.do") != -1) {
			BoardDTO dto = new BoardDTO();
			File uploadDir = new File(Constants.UPLOAD_PATH);
			if(!uploadDir.exists()) {				// 디렉토리가 없으면
				uploadDir.mkdir();					// 디렉토리 생성해라
			}
			MultipartRequest multi = new MultipartRequest(request, Constants.UPLOAD_PATH, 
									Constants.MAX_UPLOAD, "utf-8", new DefaultFileRenamePolicy());
			String filename = " ";
			int filesize = 0;
			try {
				Enumeration files = multi.getFileNames();	// 첨부파일 집합
				while(files.hasMoreElements()) {			// 다음 요소가 있으면
					String file1 = (String)files.nextElement();	// 다음 파일 읽기
					filename = multi.getFilesystemName(file1);	// 파일 이름
					File f1 = multi.getFile(file1);				// 파일 참조변수(파일의 정보)
					if(f1 != null) {					// 첨부파일이 있으면
						filesize = (int)f1.length();	// 파일 사이즈
						if(filename != null) {
							int start = filename.lastIndexOf(".") + 1;	// 확장자의 인덱스
							if(start != -1) {							// 마침표가 있으면
								String ext = filename.substring(start, filename.length());
								if(ext.equals("jsp") || ext.equals("exe")) {
									try {
										System.out.println("금지된 파일 입니다...");
										f1.delete();
									} catch (Exception e) {
										e.printStackTrace();
									} System.out.println("삭제완료!");
									// 작업중단, writer.jsp로 이동
									response.sendRedirect(request.getContextPath() + 
											"/board/write.jsp?message=error");
									return;
								}
							}
						}
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			// 위에 까지는 첨부파일 처리, 아래부터는 폼에 입력한 텍스트 처리
			String writer = multi.getParameter("writer");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			String passwd = multi.getParameter("passwd");
			String ip = request.getRemoteAddr();
			dto.setWriter(writer);		// 입력되 내용을 저장
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			dto.setIp(ip);
			if(filename == null || filename.trim().equals(""))	// 첨부파일이 없는 경우
				filename = "-";									// 그냥 하이픈(-) 입력
			dto.setFilename(filename);
			dto.setFilesize(filesize);
			
			dao.insert(dto);			// 레코드 추가 완료
			String page = contextPath + "/board_servlet/list.do";
			response.sendRedirect(page);
		} else if(url.indexOf("view.do") != -1) {
			int num = Integer.parseInt(request.getParameter("num"));	// String인 글번호를 int로 변환
			HttpSession session = request.getSession();		// request.getSession() : 세션 객체 생성
			dao.plusReadCount(num, session);				// 조회수 증가 처리
			BoardDTO dto = dao.view(num);					// 상세 레코드를 dto에 저장
			request.setAttribute("dto", dto);				// 출력할 데이터를 저장
			String page = "/board/view.jsp";				// 출력 페이지	
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("download.do") != -1) {
			int num = Integer.parseInt(request.getParameter("num"));
			String filename = dao.getFileName(num);				// 첨부파일 이름
			String path = Constants.UPLOAD_PATH + filename;		// 파일 경로 지정
			byte b[] = new byte[4096];							// 바이트 배열
			// 서버 => 클라이언트
			FileInputStream fis = new FileInputStream(path);	// 서버에 저장된 파일 읽기
			String mimeType = getServletContext().getMimeType(path);
			if(mimeType == null) {
				mimeType = "application/octet-stream;charset=UTF-8";
			}
			// header(파일이름) + body
			// 스트링.getBytes("utf-8") 스트링을 바이트 배열로, 8859_1 서유럽언어 인코딩
			filename = new String(filename.getBytes("utf-8"), "8859_1");
			// 첨부파일 이름
			response.setHeader("content-Dispostion", "attachment;filename=" + filename);
			// 클라이언트에 전송하기 위한 스트림
			ServletOutputStream out = response.getOutputStream();
			int numRead;
			while(true) {
				numRead = fis.read(b, 0, b.length);		// 서버에서 읽어들임
				if(numRead == -1) break;				// 더이상 내용이 없으면 종료
				out.write(b, 0, numRead);
			}
				out.flush();		// 버퍼를 비우는 작업
				out.close();		// 스트림 닫는 작업
				fis.close();
				dao.plusDown(numRead);	// 조회수 증가 처리
		} else if(url.indexOf("comment_add.do") != -1) {
			BoardCommentDTO dto = new BoardCommentDTO();
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			dto.setBoard_num(board_num);
			dto.setWriter(writer);
			dto.setContent(content);
			dao.commentAdd(dto);
		} else if(url.indexOf("commentList.do") != -1) {
			int num = Integer.parseInt(request.getParameter("num"));	// 글번호
			List<BoardCommentDTO> list = dao.commentList(num);			// 댓글 리스트
			request.setAttribute("list", list);							// 저장
			String page = "/board/comment_list.jsp";					// 댓글 출력 페이지
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("pass_check.do") != -1) {		// view.jsp에서 num과 passwd가 넘어감
			int num = Integer.parseInt(request.getParameter("num"));
			String passwd = request.getParameter("passwd");
			String result = dao.passwdCheck(num, passwd);
			String page = "";
			if(result != null) {			// 비번이 맞으면
				page = "/board/edit.jsp";	// 편집페이지로 이동
				request.setAttribute("dto", dao.view(num));	// 자료 저장
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			} else {
				page = contextPath + "/board_servlet/view.do?num="+num+"&message=error";	// view.jsp 메시지 파라미터
				response.sendRedirect(page);
			}
		} else if(url.indexOf("update.do") != -1) {
			BoardDTO dto = new BoardDTO();
			MultipartRequest multi = new MultipartRequest(request, Constants.UPLOAD_PATH,
									Constants.MAX_UPLOAD, "utf-8", new DefaultFileRenamePolicy());
			String filename = "";
			int filesize = 0;
			try {
				Enumeration files = multi.getFileNames();
				while(files.hasMoreElements()) {
					String file1 = (String)files.nextElement();
					filename = multi.getFilesystemName(file1);
					File f1 = multi.getFile(file1);
					if(f1 != null) {
						filesize = (int)f1.length();
						if(filename != null) {
							int start = filename.lastIndexOf(".") + 1;
							if(start != -1) {
								String ext = filename.substring(start, filename.length());
								if(ext.equals("jsp") || ext.equals("exe")) {
									try {
										System.out.println("금지된 파일 입니다.");
										f1.delete();
								} catch (Exception e) {
									e.printStackTrace();
								} System.out.println("삭제됨..");
								response.sendRedirect(request.getContextPath() + "/board/write.jsp?message=error");
								return;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			String writer = multi.getParameter("writer");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			String passwd = multi.getParameter("passwd");
			String ip = request.getRemoteAddr();
			int num = Integer.parseInt(multi.getParameter("num"));
			String fileDel = multi.getParameter("fileDel");
			if(fileDel != null && fileDel.equals("on")) {
				String fileName = dao.getFileName(num);
				File f = new File(Constants.UPLOAD_PATH + fileName);
				f.delete();
				dto.setNum(num);
				dto.setWriter(writer);
				dto.setSubject(subject);
				dto.setContent(content);
				dto.setPasswd(passwd);
				dto.setIp(ip);
				dto.setFilename("-");
				dto.setFilesize(0);
				dto.setDown(0);
				dao.update(dto);
			}
			dto.setNum(num);
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			dto.setIp(ip);
			
			if(filename == null || filename.trim().equals("")) {
				BoardDTO dto2 = dao.view(num);
				String fName = dto2.getFilename();
				int fSize = dto2.getFilesize();
				int fDown = dto2.getDown();
				dto.setFilename(fName);
				dto.setFilesize(fSize);
				dto.setDown(fDown);
			} else {
				dto.setFilename(filename);
				dto.setFilesize(filesize);
			}
			String result = dao.passwdCheck(num, passwd);
			if (result != null) {
				dao.update(dto);
				String page = contextPath + "/board_servlet/list.do";
				response.sendRedirect(page);
			} else {
				request.setAttribute("dto", dto);
				String page = "/board/edit.jsp?pwd_error=y";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} else if(url.indexOf("delete.do") != -1) {
			MultipartRequest multi = new MultipartRequest(request, Constants.UPLOAD_PATH,
									Constants.MAX_UPLOAD, "utf-8", new DefaultFileRenamePolicy());
			int num = Integer.parseInt(multi.getParameter("num"));	// 게시물 번호
			String passwd = multi.getParameter("passwd");			// 비밀번호
			String result = dao.passwdCheck(num, passwd);			// 비밀번호 체크
			if(result != null) {				// 비밀번호가 맞으면
				dao.delete(num);				// 레코드 삭제
				String page = contextPath + "/board_servlet/list.do";
				response.sendRedirect(page);	// 목록으로 이동
			} else {							// 비밀번호가 틀리면
				request.setAttribute("dto", dao.view(num));
				String page = "/board/edit.jsp?pwd_error=y";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} else if(url.indexOf("reply.do") != -1) {
			int num = Integer.parseInt(request.getParameter("num"));
			BoardDTO dto = dao.view(num);	// 원글 내용 저장
			dto.setContent("======게시물의 내용======\n" + dto.getContent());
			request.setAttribute("dto", dto);	// 출력위해 저장
			String page="/board/reply.jsp";		// 답변글 저장하는 페이지로 이동
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("insertReply.do") != -1) {
			int num = 0;
			if(request.getParameter("num") != null) {					// 글번호가 null이 아니면
				num = Integer.parseInt(request.getParameter("num"));	// 받아서 저장하세요
			}
			BoardDTO dto = dao.view(num);
			int ref = dto.getRef();						// getRef : 답변그룹
			int re_step = dto.getRe_step() + 1;			// Re_step : 답변순서 (기존글에 +1)
			int re_level = dto.getRe_level() + 1;		// getRe_leve : 답변단계 (기존글에 +1)
			String writer = request.getParameter("writer");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String passwd = request.getParameter("passwd");
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			dto.setRef(ref);
			dto.setRe_step(re_step);
			dto.setRe_level(re_level);
			dto.setFilename("-");				// 파일은 하지 않아서 그냥 기본값으로 설정
			dto.setFilesize(0);
			dto.setDown(0);
			dao.updateStep(ref, re_step);		// 순서조정	
			dao.reply(dto);						// 답글 저장
			String page = "/board_servlet/list.do";		// 목록으로 이동
			response.sendRedirect(contextPath + page);
		} else if(url.indexOf("search.do") != -1) {
			String search_option = request.getParameter("search_option");	// 검색옵션
			String keyword = request.getParameter("keyword");				// 검색키워드
			int count = dao.count(search_option, keyword);					// 레코드 갯수 계산		
			int curPage = 1;												// 현재 페이지 번호
			if(request.getParameter("curPage") != null) {					// 요청한 페이지 번호
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			Pager pager = new Pager(count, curPage);
			int start = pager.getPageBegin();
			int end = pager.getPageEnd();		
			List<BoardDTO> list = dao.searchList(search_option, keyword, start, end);	
			request.setAttribute("list", list);		
			request.setAttribute("search_option", search_option);
			request.setAttribute("keyword", keyword);
			request.setAttribute("page", pager);	
			String page = "/board/search.jsp";		
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} 
		
		
	}

	
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
