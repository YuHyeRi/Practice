package com.gd.test.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

// AOP((Aspect-Oriented Programming) : 관점지향 프로그래밍, 공통활용 부분의 반복코딩 감소
// ** 설정 방법
// 1) pom.xml => aspectjweaver,aspectjtools 2개를 세팅후 스프링에서 설정해줘야함.
// 2) servlet-context.xml => - <aop:aspectj-autoproxy> ==> 자동으로 연결해줌
// 	- <beans:bean id="commonAop" class="com.gd.test.common.controller.CommonAOP"> ==> 옛날 방식의 객체 생성
// 	- autoproxy : 설정을 읽어온다. 
// 3) CommonAOP.java -> execution -> include필터 먼저 선언 -> !execution -> exclude필터 선언 -> CalendarController에 있는 모든 메서드를 대상으로 

// Aspect 어노테이션!
@Aspect
public class CommonAOP {
	// @Pointcut(범위설정) --> 적용범위
	/*
	 * 범위
	 * execution -> include필터
	 * !execution -> exclude필터
	 * * -> 모든것
	 * *(..) -> 모든 메소드
	 * .. -> 모든 경로
	 * && -> 필터 추가
	 * || -> OR 필터(잘못쓰면 독이기 때문에 잘 쓰지 않음)
	 */
	
	// pointcut : 대상지정 하는 것
	// 로그인이나 권한처리 등에 쓰일 수 있겠지?
	// * 한칸띄고 com~.sample안에 있는 어떤 경로를 거치던 TestAController안의 모든 메소드들 중 뒤가 s,list,AB 로 끝나는 것들이 아닌 것들
	@Pointcut("execution(* com.gd.test..TestAController.*(..))"
			 + "&& !execution(* com.gd.test..TestAController.*s(..))"
			 + "&& !execution(* com.gd.test..TestAController.*List(..))"
 			 + "&& !execution(* com.gd.test..TestAController.*AB(..))"
			 + "&& !execution(* com.gd.test..TestAController.*Update(..))")
	public void testAOP() {}
	
	// ProceedingJoinPoint -> 대상 적용 이벤트 필터
	/*
	 * @Before -> 메소드 실행 전
	 * @After -> 메소드 실행 후
	 * @After-returning -> 메소드 정상실행 후
	 * @After-throwing -> 메소드 예외 발생 후
	 * @Around -> 모든 동작시점 (Before + After/ 두번 실행)
	 */
	
	// around : pointcut으로 지정한 메소드명을 써준다
	// Pointcut 에서 지정한 범위인 메소드들에게 이러한 관점(Around)으로 보겠다.
	// 대상을 먼저 지정, 관점 지정
	// ProceedingJoinPoint joinPoint (기존의 동작중인 이벤트를 취득하겠다.//계속 진행할지 말지 결정해야함)
	// modelAndView 수동으로 만듬
	@Around("testAOP()")
	public ModelAndView testAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		ModelAndView mav = new ModelAndView();
		
		// Request 객체 취득
		HttpServletRequest request
		= ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		// 추가한 부분
		HttpSession session = request.getSession();	// 세션 취득
		
		if(session.getAttribute("sMNo") != null) {
			mav = (ModelAndView) joinPoint.proceed(); // 기존 이벤트 처리 행위를 이어서 진행
		} else {
			mav.setViewName("redirect:mLogin");
		}
		
		System.out.println("------- testAOP 정상 실행! ------");
		
		return mav;
	}
	
} // Aspect end