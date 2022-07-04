package com.gd.test.web.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.test.service.ITestService;

@Controller
public class TestController {

	// Controller -> Service -> dao -> SqlSession
	@Autowired	
	public ITestService iTestService;
	
	@Autowired		// 페이징을 위해 객체 생성
	public IPagingService iPagingService;
	
	// http://localhost:82/SampleSpring/testList
	@RequestMapping(value="/testList")
	public ModelAndView testList(
			@RequestParam HashMap<String, String> params,	// HashMap으로 받으면 나중에 옵션갯수가 변경되어도 상관 X
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		// 페이징을 위한 데이터 => 현재 페이지
		int page = 1;										// 현재 페이지 변수
		if(params.get("page") != null) {					// 넘어오는 현재 페이지 데이터가 존재할 경우 (없다면 1)
			page = Integer.parseInt(params.get("page"));
		}
		// 페이징을 위한 데이터 => 총 게시물(데이터) 갯수
		int cnt = iTestService.getB1Cnt(params);			// 총 게시물 갯수(단일컬럼의 단일로우 데이터 하나)
		
		// 페이징을 위해 추가
		PagingBean pb = iPagingService.getPagingBean(page, cnt);
		// public PagingBean getPagingBean(int page, int maxCount, int viewCnt, int pageCnt);
		// PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 10);	
		// 한 페이지에 5줄씩 게시글을 display, 밑에 페이지(ex. [이전] 1 2 3 4, ... [다음])는 10개씩 보여주겠다
		
		// 데이터 시작, 종료 번호 추가 ==> 페이징을 위해 추가
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		// 실행할 쿼리의 row가 여러줄이니까 list로 받음(중요!)
		// 컬럼이 여러개니까 HashMap으로 받고 그게 여러줄의 row니까 list로 담기
		// cf. 배열의 경우 크기가 고정이라 보다 유동적인 list를 씀
		List<HashMap<String, String>> list = iTestService.getB1List(params);
		
		mav.addObject("page", page);		// 페이징을 위해 추가
		mav.addObject("pb", pb);			// 페이징을 위해 추가
		// mav.addObject("cnt", cnt);			// 페이징을 위해 추가 (총게시글 수)
		mav.addObject("list", list);
		mav.setViewName("/test/testList");
		return mav;
	}
	
	// 상세보기
	@RequestMapping(value="/testDtl")
	public ModelAndView testDtl(
			@RequestParam HashMap<String, String> params,	// 해시맵으로 받는 이유는 데이터를 여러개 받을거니까
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		// 상세보기는 컬럼이 여러개니까 hashMap으로 받는다(여러줄은 아니니까 list로 받지는 X)
		HashMap<String, String> data = iTestService.getB1(params);	
		
		mav.addObject("data", data);	
		mav.setViewName("/test/testDtl");
		return mav;
	}
	
	// 글쓰기
	@RequestMapping(value="/testAdd")
	public ModelAndView testAdd(ModelAndView mav) {			// 글쓰는 화면만 띄울거라 때문에 예외처리 안함
		mav.setViewName("/test/testAdd");					// location에서 그냥 주소를 넘겨받는거라 넘어올 값 X
		return mav;
	}
	
	// 글쓰기2
	@RequestMapping(value="/testAdds")
	public ModelAndView testAdds(
			@RequestParam HashMap<String, String> params,	// 사용자가 글을 작성하면 해당 값이 넘어옴
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		int cnt = iTestService.addB1(params);				// insert시 건수만 돌려줌 (실행건수)
		
		if(cnt > 0) {										// 조건에 따라 이동하는 곳이 다름, 성공시 list로 이동
			mav.setViewName("redirect:testList");			
		} else {											
			mav.addObject("msg", "저장에 실패하였습니다.");		// 실패시 해당 메시지를 보여주고
			mav.setViewName("/test/failedAction");			// 실패시 failedAction 페이지로 이동 (추가작업필요)
		}
		return mav;
	}
	
	// 글 수정(화면내용:상세보기 + 화면구성:글작성) ==> testDtl 복붙 후 수정
	@RequestMapping(value="/testUpdate")
	public ModelAndView testUpdate(
			@RequestParam HashMap<String, String> params,	
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		HashMap<String, String> data = iTestService.getB1(params);
		
		mav.addObject("data", data);
		mav.setViewName("/test/testUpdate");
		return mav;
	}
	
	// 글 수정 ==> testAdds 복붙 후 수정
	@RequestMapping(value="/testUpdates")
	public ModelAndView testUpdates(
			@RequestParam HashMap<String, String> params,	
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		int cnt = iTestService.updateB1(params);			// update시 건수만 돌려줌 (실행건수)

		if(cnt > 0) {										// 수정작업 성공시
			mav.setViewName("/test/testUpdates");			// testUpdates.jsp로 이동
		} else {											
			mav.addObject("msg", "저장에 실패하였습니다.");
			mav.setViewName("/test/failedAction");
		}
		return mav;
	}
	
	// 글 삭제 ==> testAdds 복붙 후 수정
	@RequestMapping(value="/testDelete")
	public ModelAndView testDelete(
			@RequestParam HashMap<String, String> params,	
			ModelAndView mav) throws Throwable {			// DB에 붙으니까 예외처리
		
		int cnt = iTestService.deleteB1(params);			// delete시 건수만 돌려줌 (실행건수)

		if(cnt > 0) {		
			mav.setViewName("redirect:testList");
		} else {			
			mav.addObject("msg", "삭제에 실패하였습니다.");
			mav.setViewName("/test/failedAction");
		}
		return mav;
	}
	
	// 제이쿼리 연습용
	@RequestMapping(value="/testJ")
	public ModelAndView testj(ModelAndView mav) {
		
		mav.setViewName("testJ/testJ");
		return mav;
	}
	
	
}	// class
