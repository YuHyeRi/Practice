package com.gd.test.web.exam2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gd.test.common.bean.PagingBean;
import com.gd.test.common.service.IPagingService;
import com.gd.test.util.Utils;
import com.gd.test.web.exam2.service.IMService;

@Controller
public class MController {
	
	// 페이징, 검색
	
	@Autowired
	public IMService iMService;
	
	@Autowired
	public IPagingService iPagingService;
	
	// 리스트 : getListM, MCnt
	@RequestMapping(value="/mList")
	public ModelAndView mList(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int page = 1;
		
		// 넘어온 페이지 값이 있을 경우 값 셋팅
		if(params.get("page") != null) {		
			page = Integer.parseInt(params.get("page"));
		}
		
		// 글 갯수
		int cnt = iMService.MCnt(params);
		
		// 페이징 계산후 bean에 데이터 셋팅
		PagingBean pb = iPagingService.getPagingBean(page, cnt, 10, 3);
		
		// 조회시작 및 종료번호 할당
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String, String>> list = iMService.getListM(params);
		
		mav.addObject("page", page);
		mav.addObject("pb", pb);
		mav.addObject("list", list);
		mav.setViewName("exam2/mList");		// 이미 앞 /가 있기 때문에 슬러시 빼주기
		return mav;
	};
	
	// 상세페이지 : getM
	@RequestMapping(value="/mDtl")
	public ModelAndView mDtl(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iMService.getM(params);
		
		mav.addObject("data", data);
		mav.setViewName("exam2/mDtl");
		return mav;
	}
	
	// 글쓰기
	@RequestMapping("/mAdd")
	public ModelAndView mAdd(ModelAndView mav) {
		mav.setViewName("exam2/mAdd");
		return mav;
	}
	
	// 글쓰기2 : addM (+아이디 중복체크 추가 : mIdCheck => 순서잘보기)
	// 비밀번호 암호화 추가 (adds, updates, logins)
	@RequestMapping("/mAdds")
	public ModelAndView mAdds(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int checkCnt = iMService.mIdCheck(params);
		
		if(checkCnt == 0) {		// 아이디가 없으면(중복된 아이디가 없으면)
			// 비밀번호 암호화
			// 글쓰기.jsp에서는 M_PW로 보냈으니까!
			String pw = Utils.encryptAES128(params.get("M_PW"));
			params.put("M_PW", pw);
			
			int cnt = iMService.addM(params);
			
			if(cnt>0) {
				mav.setViewName("redirect:mList");
			} else {
				mav.addObject("msg", "등록중 문제가 발생했습니다.");
				mav.setViewName("exam/yhrError");
			}
		} else {
			mav.addObject("msg", "중복된 아이디가 존재합니다.");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 글수정
	@RequestMapping(value="/mUpdate")
	public ModelAndView mUpdate(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iMService.getM(params);
		
		// 비밀번호 복호화 필요 (복호화는 update만)
		// 글수정.jsp에서는 M_PW로 보냈으니까!
		String pw = Utils.decryptAES128(data.get("M_PW"));
		data.put("M_PW", pw);
		
		mav.addObject("data", data);
		mav.setViewName("exam2/mUpdate");
		return mav;
	}
	
	// 글수정2 : updateM
	@RequestMapping(value="/mUpdates")
	public ModelAndView mUpdates(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		// 글수정.jsp에서는 M_PW로 보냈으니까!
		String pw = Utils.encryptAES128(params.get("M_PW"));
		params.put("M_PW", pw);
		
		int cnt = iMService.updateM(params);
		
		if(cnt>0) {
			mav.setViewName("exam2/mUpdates");
		} else {
			mav.addObject("msg", "수정중 문제가 발생했습니다.");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 글삭제 : deleteM
	@RequestMapping("/mDelete")
	public ModelAndView mDelete(
			@RequestParam HashMap<String, String> params,
			ModelAndView mav) throws Throwable {
		
		int cnt = iMService.deleteM(params);
		
		if(cnt > 0) {
			mav.setViewName("redirect:mList");
		} else {
			mav.addObject("msg", "삭제중 문제가 발생했습니다.");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 로그인
	// http://localhost:82/SampleSpring/mLogin
	// 주소를 여러개 할당하고 싶다면, 주소에 배열을 만들어 주면 OK {"", "", ...}
	@RequestMapping(value= {"/mLogin", "/testLogin"})
	public ModelAndView mLogin(
			HttpServletRequest req,		// path 보려고 추가(주소가 여러개라면)
			HttpSession session,
			ModelAndView mav) {
		System.out.println(req.getServletPath()); // path 볼 수 있음
		
		if(session.getAttribute("sMNo") != null) {	// 로그인 중이라면
			// mav.setViewName("redirect:testO");		// 로그인페이지를 보여줄필요 없으니까 바로 게시판으로 돌아감
			mav.setViewName("redirect:testABList");	
			
		} else {									// 로그인 안된 상태라면
			mav.setViewName("exam2/mLogin");		// 로그인 페이지를 보여줌
		}
		return mav;
	} 
	
	// 로그인2 : loginM
	@RequestMapping(value="/mLogins")
	public ModelAndView mLogins(
			@RequestParam HashMap<String, String> params,
			// HttpServletRequest req,	// 1번 취득방식
			HttpSession session,	// 추가!) 2번 취득방식 (1번방식을 쓰면 두줄 써야하지만, 얘는 한줄만 쓰면 ok)
			ModelAndView mav) throws Throwable {
		
		// login.jsp에서는 pw로 보냈으니까 pw로 씀
		String pw = Utils.encryptAES128(params.get("pw"));
		params.put("pw", pw);
		
		HashMap<String, String> data = iMService.loginM(params);
		
		if(data != null) {	// 사용자 데이터 있을 경우
			// *session 취득방법
			// 1. request 활용
			// 2. 인자를 통하여 session 요청
			// HttpSession session = req.getSession();	// 1번 취득방식 => spring에서는 AOP제외하고는 안씀
			
			// "set" ==> setAttribute(키, 값) : 세션에 해당하는 키와 값을 넣는다
			// session사용법은 map과 동일하다
			session.setAttribute("sMNo", data.get("M_NO"));	// 추가!) 보통 앞에 s를 붙임 (==> 이게 '세션에서 만들어진거다'라는 말)
			session.setAttribute("sMNm", data.get("M_NM"));	// 추가!)
			
			// "get" 값 잘 가져왔는지 확인 ==> getAttribute(키) : 세션에서 키에 해당하는 값을 가져온다
			System.out.println("sMNo 값 ==> " + session.getAttribute("sMNo"));
			System.out.println("sMNm 값 ==> " + session.getAttribute("sMNm"));
			
			/* mav.setViewName("redirect:testO"); */
			mav.setViewName("redirect:testABList");
		} else {			// 사용자 데이터 없을 경우(로그인실패)
			mav.addObject("msg", "아이디나 비밀번호가 틀립니다.");
			mav.setViewName("exam/yhrError");
		}
		return mav;
	}
	
	// 로그아웃
	@RequestMapping(value="/mLogout")
	public ModelAndView mLogout(
			HttpSession session,
			ModelAndView mav) {			// 로그아웃이 진짜 간단한게 심지어 DB에 붙지도 않음
		
		session.invalidate();			// session정보 초기화
		// mav.setViewName("redirect:testO");
		mav.setViewName("redirect:mLogin");
		return mav;
	}
	
	
}	// end
