package com.gd.test.web.exam3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.gd.test.util.Utils;
import com.gd.test.web.exam3.service.ITestMService;

@Controller
public class TestMController {
	
	@Autowired
	public ITestMService iTestMService;
	
	@Autowired
	public IPagingService iPagingService;
	
	// 리스트, 페이징 1
	@RequestMapping(value="/testMList")
	public ModelAndView testMList(@RequestParam HashMap<String, String> params, ModelAndView mav) {
		
		int page = 1;
		
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		mav.addObject("page", page);
		mav.setViewName("exam3/testMList");		// testMList.jsp
		return mav;
	}
	
	// 리스트, 검색, 페이징 2
	@RequestMapping(value="/testMLists", method=RequestMethod.POST, produces="text/json;charset=UTF-8")
	
	@ResponseBody
	public String testMLists(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		int page = Integer.parseInt(params.get("page"));
		int cnt = iTestMService.getMCnt(params);	// 게시글 수
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 3);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iTestMService.getMList(params);
		modelMap.put("list", list);
		modelMap.put("pb", pb);
		
		return mapper.writeValueAsString(modelMap);
	}
	
	// 새로등록 1
	@RequestMapping(value="/testMAdd")
	public ModelAndView testMAdd(ModelAndView mav) {
		mav.setViewName("exam3/testMAdd");		// testMAdd.jsp
		return mav;
	}
	
	// 새로등록 2 -> 여기서 add, update, delete 모두 처리
	@RequestMapping(value="/testMAdds", method=RequestMethod.POST, produces="text/json;charset=UTF-8")
	
	@ResponseBody
	public String testMAdds(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		String result = "success";
		
		try {
			int cnt = 0;
			
			switch(params.get("gbn")) {
			case "c" : 
				params.put("pw", Utils.encryptAES128(params.get("pw")));
				cnt = iTestMService.addTestM(params);
				break;
			case "u" : 
				params.put("pw", Utils.encryptAES128(params.get("pw")));
				cnt = iTestMService.updateTestM(params);
				break;
			case "d" : 
				cnt = iTestMService.delTestM(params);
				break;
			}
			
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
	
	// 아이디 중복체크 : testMIdCheck
	@RequestMapping(value="/testMIdCheck", method=RequestMethod.POST, produces="text/json;charset=UTF-8")
		
	@ResponseBody
	public String testMIdCheck(@RequestParam HashMap<String, String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
			
		Map<String, Object> modelMap = new HashMap<String, Object>();
			
		int cnt = iTestMService.getM1IdCheck(params);
			
		modelMap.put("cnt", cnt);
		return mapper.writeValueAsString(modelMap);
	}
	
	// 상세보기
	@RequestMapping(value="/testMDtl")
	public ModelAndView testMDtl(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
			
		HashMap<String, String> data = iTestMService.getM(params);
			
		mav.addObject("data", data);
		mav.setViewName("exam3/testMDtl");		// testMDtl.jsp
		return mav;
	}
	
	// 수정 1 (상세보기와 동일) : testMUpdate
	@RequestMapping(value="/testMUpdate")
	public ModelAndView testMUpdate(@RequestParam HashMap<String, String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iTestMService.getM(params);
			
		// 복호화
		data.put("M_PW", Utils.decryptAES128(data.get("M_PW")));
		
		mav.addObject("data", data);
		mav.setViewName("exam3/testMUpdate");		// testMUpdate.jsp
		return mav;
	}
	
//	// 수정 2 (add와 동일)
//	@RequestMapping(value="/testMUpdates", method=RequestMethod.POST, produces="text/json;charset=UTF-8")
//	
//	@ResponseBody
//	public String testMUpdates(@RequestParam HashMap<String, String> params) throws Throwable {
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		
//		String result = "success";
//		// 추가부분 : encrypt(암호화)
//		String pw = Utils.encryptAES128(params.get("pw"));
//		params.put("pw", pw);
//		
//		try {
//			int cnt = iTestMService.updateTestM(params);
//			
//			if(cnt == 0) {
//				result = "failed";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = "error";
//		}
//	
//		modelMap.put("result", result);
//		return mapper.writeValueAsString(modelMap);
//	}
	
//	// 삭제 (수정2와 동일)
//	@RequestMapping(value="/testMDelelte", method=RequestMethod.POST, produces="text/json;charset=UTF-8")
//	
//	@ResponseBody
//	public String testMDelelte(@RequestParam HashMap<String, String> params) throws Throwable {
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		
//		String result = "success";
//		
//		try {
//			int cnt = iTestMService.delTestM(params);
//			
//			if(cnt == 0) {
//				result = "failed";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = "error";
//		}
//	
//		modelMap.put("result", result);
//		return mapper.writeValueAsString(modelMap);
//	}
	

}	// class end
