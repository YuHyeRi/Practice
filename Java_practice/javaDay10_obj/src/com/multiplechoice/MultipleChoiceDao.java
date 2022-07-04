package com.multiplechoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Dao : Data Access Object -> 데이터베이스에 데이터 읽고 쓰기 담당 클래스
public class MultipleChoiceDao {
	String jungdap = "12345123451234512345";	// 우선 정답 고정
	
	List<MultipleChoiceDto> list = new ArrayList<MultipleChoiceDto>();
	
	// 생성자 - 테스트용
	public MultipleChoiceDao() {
		list.add(new MultipleChoiceDto("홍길동1", "12345123451234512345"));
		list.add(new MultipleChoiceDto("홍길동2", "12312512323123451234"));
		list.add(new MultipleChoiceDto("홍길동3", "12345123451221512315"));
		list.add(new MultipleChoiceDto("홍길동4", "12345123452223451345"));
		list.add(new MultipleChoiceDto("홍길동5", "12345123451234123425"));
	}
	
	// 메서드1 - 입력
	public void append() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("답 : ");
		String dap = sc.next();
		
		MultipleChoiceDto d1 = new MultipleChoiceDto(name, dap);
		list.add(d1);
	}
	
	// 메서드2 - 계산
	public void process() {
		for(int i =0; i<list.size(); i++) {
			// 리스트에 저장된 데이터 가지고 와서
			MultipleChoiceDto dto = list.get(i);
			// 정답과 dto.dap의 데이터를 비교해서 ox를 하고
			for(int j=0; j<jungdap.length(); j++) {
				// 정답과 입력답이 맞는지 비교하면서 채점하는 부분
				if(dto.getDap().charAt(j) == jungdap.charAt(j))	{	// 문자비교
					dto.setCnt(dto.getCnt()+1);
					dto.setOx(dto.getOx() + "O");
				} else {
					dto.setOx(dto.getOx() + "X");
				}
			}
		}
	}
	
	// 메서드3 - 출력
	public void output() {
		for(int i =0; i<list.size(); i++) {
			MultipleChoiceDto dto = list.get(i);
			System.out.printf("%s %s %s %d\n", 
					dto.getName(), dto.getDap(), dto.getOx(), dto.getCnt());
		}
	}

}
