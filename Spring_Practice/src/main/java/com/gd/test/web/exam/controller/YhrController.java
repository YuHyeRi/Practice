package com.gd.test.web.exam.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.exam.service.IYhrService;


@Controller
public class YhrController {
	
	@Autowired
	public IYhrService iYhrService;
	@Autowired 
	public IPagingService iPagingService;
	
	// 목록
	@RequestMapping(value="/yhrList")
	public ModelAndView yhrList(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int page = 1;
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iYhrService.SELLCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 19, 10);
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iYhrService.SELLList(params);
		
		mav.addObject("page", page);
		mav.addObject("pb", pb);
		mav.addObject("list", list);
		mav.setViewName("/exam/yhrList");
		return mav;
	}
	
	// 상세페이지
	@RequestMapping(value="/yhrDtl")
	public ModelAndView yhrDtl(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iYhrService.SELL(params);
		
		mav.addObject("data", data);
		mav.setViewName("/exam/yhrDtl");
		return mav;
	}
	
	// 글쓰기
	@RequestMapping(value="/yhrAdd")
	public ModelAndView yhrAdd(ModelAndView mav) {
		
		mav.setViewName("/exam/yhrAdd");
		return mav;
	}
	
	// 글쓰기2
	@RequestMapping(value="/yhrAdds")
	public ModelAndView yhrAdds(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int cnt = iYhrService.addSELL(params);
		
		if(cnt > 0) {
			mav.setViewName("redirect:yhrList");
		} else {
			mav.setViewName("/exam/yhrError");
		}
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value="/yhrUpdate")
	public ModelAndView yhrUpdate(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iYhrService.SELL(params);
		
		mav.addObject("data", data);
		mav.setViewName("/exam/yhrUpdate");
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value="/yhrUpdates")
	public ModelAndView yhrUpdates(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int cnt = iYhrService.updateSELL(params);
		
		if(cnt > 0) {
			mav.setViewName("/exam/yhrUpdates");
		} else {
			mav.setViewName("/exam/yhrError");
		}
		return mav;
	}
	
	// 글 삭제
	@RequestMapping(value="/yhrDelete")
	public ModelAndView yhrDelete(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int cnt = iYhrService.deleteSELL(params);
		
		if(cnt > 0) {
			mav.setViewName("redirect:yhrList");
		} else {
			mav.setViewName("/exam/yhrError");
		}
		return mav;
	}
	

}	// class end
