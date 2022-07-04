package com.gd.test.web.testO.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.web.testO.service.ITestOService;

@Controller
public class TestOController {
	
	@Autowired
	public ITestOService iTestOService;
	
	@Autowired
	public IPagingService iPagingService;

	// 리스트 : listO, 페이징 : cntO
	@RequestMapping(value="/testO")
	public ModelAndView testO(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int page = 1;
		if(params.get("page") != null) {
			page = Integer.parseInt(params.get("page"));
		}
		
		int cnt = iTestOService.cntO(params);
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 5, 2);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iTestOService.listO(params);
		
		mav.addObject("page", page);
		mav.addObject("pb", pb);
		mav.addObject("list", list);
		mav.setViewName("testO/testO");
		return mav;
	}
	
	// 글작성
	@RequestMapping(value="/addO")
	public ModelAndView addO(ModelAndView mav) {
		mav.setViewName("testO/testO");
		return mav;
	}
	
	// 글작성2 : addO
	@RequestMapping(value="/addsO")
	public ModelAndView addsO(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		int cnt = iTestOService.addO(params);
		if(cnt>0) {
			mav.setViewName("redirect:testO");
		} else {
			mav.addObject("msg", "Error");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 글삭제 : delO
	@RequestMapping(value="/delO")
	public ModelAndView delO(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		int cnt = iTestOService.delO(params);
		if(cnt>0) {
			mav.setViewName("redirect:testO");
		} else {
			mav.addObject("msg", "Error");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 글 수정 : updateO
	@RequestMapping(value="/updateO")
	public ModelAndView updateO(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int cnt = iTestOService.updateO(params);
		if(cnt>0) {
			mav.setViewName("redirect:testO");
		} else {
			mav.addObject("msg", "Error");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	
	
	
}	// class
