package com.gd.test.web.testa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.testa.service.ITestAService;

@Controller
public class TestAController {
	
	@Autowired 
	public ITestAService iTestAService;
	
	@Autowired
	public IPagingService iPagingService;
	
	// 에디터 달기, 조회수 달기, 삭제를 flag처리
	// 기존에 우리가 s로 처리했던 것들이 비동기로 바뀌는 것
	
	@RequestMapping(value="/testABList")
	public ModelAndView testABList(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) {
		
		String page = "1";
		if(params.get("page") != null) {
			page = params.get("page");
		};
		
		mav.addObject("page", page);
		mav.setViewName("testa/testABList");
		return mav;
	}
	
	// @RequestMapping - value(주소), method(전송방식), produces(돌려주는방식)
	@RequestMapping(value="/testABLists", 
					method=RequestMethod.POST, 
					produces="text/json;charset=UTF-8")
		
	// @ResponseBody : 난 view니까 아무것도 거치지 말고 그냥 하면 돼! (보통 ajax)
	// Spring에게 돌려주는 내용이 이미 완성된 view임을 제시
	// 단계를 skip한다고 생각하면 ok! viewresolver & view를 거치지 X
	@ResponseBody
	public String testABLists(	// modelandview 필요X, String으로 보낼거니까
			@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();						// jackson 객체(여러형태를 담을수있고, 그것을 문자열로)
		Map<String, Object> modelMap = new HashMap<String, Object>();	// 데이터를 담을 map
		
		// 페이지 취득
		int page = Integer.parseInt(params.get("page"));	
		// 총 게시글 수(개수) 취득
		int cnt = iTestAService.getABCnt(params);	
		// 페이징 정보 취득
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 10);
		
		// 시작,종료 값 할당
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));	
		
		// 리스트 조회
		List<HashMap<String, String>> list = iTestAService.getABList(params);
		
		// 데이터 담기
		modelMap.put("list", list);
		modelMap.put("pb", pb);
		
		// 데이터를 문자열화
		return mapper.writeValueAsString(modelMap);
	}
	
	// 이 부분에 AOP 추가함 --> /testABAdd 치고 들어갔을때 바로 mLogin 페이지가 떠야함
	@RequestMapping(value="/testABAdd")	// 단순 글작성 페이지로 이동
	public ModelAndView testABAdd(/* HttpSession session, */ ModelAndView mav) {
		
		mav.setViewName("testa/testABAdd"); // 해당 부분 추가
		
		/* CommonAOP에 넣었기 때문에 삭제
		 * if(session.getAttribute("sMNo") != null) {
		 * mav.setViewName("testa/testABAdd"); } else {
		 * mav.setViewName("redirect:mLogin"); // redirect : 다른 컨트롤러 주소로 이동 }
		 */
		return mav;
	}
	
	@RequestMapping(value="/testABAdds", 
					method=RequestMethod.POST, 
					produces="text/json;charset=UTF-8")

	@ResponseBody
	public String testABAdds(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();						
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		
		String result = "success";			// 결과를 받기 위한 문자열 셋팅
		
		try {
			int cnt = iTestAService.abAdd(params);
			
			if(cnt == 0) {
				result = "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		modelMap.put("result", result);
		return mapper.writeValueAsString(modelMap);		// 다시 문자열로 만듦
	}
	
	// 상세보기, 조회수는 여기 컨트롤러에서만 작업함 (!!조회수 증가 후 데이터를 조회)
	@RequestMapping(value="/testAB")	// 화면에 한번만 띄울거기 때문에 비동기일 필요 X
	public ModelAndView testAB(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		if(params.get("no") != null) {
			
			// 조회수 증가(받을게 없으니 No return, only 증가만)
			iTestAService.updateABHit(params);
			
			// 데이터 조회
			HashMap<String, String> data = iTestAService.getAB(params);
			mav.addObject("data",data);
			mav.setViewName("testa/testAB");	// testAB.jsp 파일 생성
		} else {
			mav.setViewName("redirect:testABList");
		}
		return mav;
	}
	
	// 수정 : 상세보기 복붙해서 이름 바꾸기
	// testABUpdate.jsp 파일 생성 (add.jsp파일 복붙)
	@RequestMapping(value="/testABUpdate")
	public ModelAndView testABUpdate(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		if(params.get("no") != null) {
			HashMap<String, String> data = iTestAService.getAB(params);
			mav.addObject("data",data);
			mav.setViewName("testa/testABUpdate");	
		} else {
			mav.setViewName("redirect:testABList");
		}
		return mav;
	}
	
	// 수정 : add 복붙해서 이름, 함수바꾸기
	@RequestMapping(value="/testABUpdates", 
					method=RequestMethod.POST, 
					produces="text/json;charset=UTF-8")

	@ResponseBody
	public String testABUpdates(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();						
		Map<String, Object> modelMap = new HashMap<String, Object>();	
	
		String result = "success";			
	
		try {
			int cnt = iTestAService.abUpdate(params);
		
			if(cnt == 0) {
				result = "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		modelMap.put("result", result);
		return mapper.writeValueAsString(modelMap);		
		}
	
	// 삭제 : 위에꺼 복붙하고 이름, 함수만 변경
	@RequestMapping(value="/testABDeletes", 
			method=RequestMethod.POST, 
			produces="text/json;charset=UTF-8")

	@ResponseBody
		public String testABDeletes(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();						
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		
		String result = "success";			
		
		try {
			int cnt = iTestAService.abDelete(params);
		
			if(cnt == 0) {
				result = "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		modelMap.put("result", result);
		return mapper.writeValueAsString(modelMap);		
	}
	
	
	

}	// class end
