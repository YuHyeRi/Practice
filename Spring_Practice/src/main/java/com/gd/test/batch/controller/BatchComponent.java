package com.gd.test.batch.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// 배치 프로그래밍 : 일정주기, 일자, 시간마다 구동되는 프로그램 (ex. 생일메시지, 금액정산, 조건에 맞는 사람들에게 메시지 전송 등)
// servlet-context 파일에서 설정 (xmlns:task)

// @Component : 일반적인 객체를 생성할 때 쓰는 어노테이션
@Component
public class BatchComponent {
	
	// 초 분 시 일 월 요일 (거꾸로 쓴다고 생각하면 ok)
	// * - 모든
	// ? - 월, 요일에 사용. 신경안씀이라는 의미
	// 월은 1 - 12
	// 요일은 1(일) - 7(토). ,(컴마)로 복수지정가능. 예)월수금 - 2,4,6
	// 숫자1/숫자2의 경우 숫자1에서 시작하여 매 숫자2마다 실행. 예) 분에 0/5이면 0분부터 5분마다 실행
	// 일에서 L은 달의 마지막날. W는 지정일자가 휴일(토, 일)이면 인접한 평일에 수행.
	// 예) 25W인경우 25일이 일요일이면 26일 월요일 실행.
	// LW는 마지막 평일
	// 요일에서 숫자1#숫자2의경우 숫자2번째 주의 숫자1번 요일에 실행.
	// 예) 2#4 - 4번째주 월요일에 실행.
	// cron : 특정시간마다 어떤 작업을 자동으로 수행하게 해주고 싶을때 사용하는 명령어 (초,분,시,일,월,요일 순)
	@Scheduled(cron = "0 0 0/1 * * *")		
	public void cronTest1() {
		System.out.println("배치프로그램 구동중");
	}

}