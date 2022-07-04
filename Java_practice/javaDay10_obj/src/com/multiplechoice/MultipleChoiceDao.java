package com.multiplechoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Dao : Data Access Object -> �����ͺ��̽��� ������ �а� ���� ��� Ŭ����
public class MultipleChoiceDao {
	String jungdap = "12345123451234512345";	// �켱 ���� ����
	
	List<MultipleChoiceDto> list = new ArrayList<MultipleChoiceDto>();
	
	// ������ - �׽�Ʈ��
	public MultipleChoiceDao() {
		list.add(new MultipleChoiceDto("ȫ�浿1", "12345123451234512345"));
		list.add(new MultipleChoiceDto("ȫ�浿2", "12312512323123451234"));
		list.add(new MultipleChoiceDto("ȫ�浿3", "12345123451221512315"));
		list.add(new MultipleChoiceDto("ȫ�浿4", "12345123452223451345"));
		list.add(new MultipleChoiceDto("ȫ�浿5", "12345123451234123425"));
	}
	
	// �޼���1 - �Է�
	public void append() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�� : ");
		String dap = sc.next();
		
		MultipleChoiceDto d1 = new MultipleChoiceDto(name, dap);
		list.add(d1);
	}
	
	// �޼���2 - ���
	public void process() {
		for(int i =0; i<list.size(); i++) {
			// ����Ʈ�� ����� ������ ������ �ͼ�
			MultipleChoiceDto dto = list.get(i);
			// ����� dto.dap�� �����͸� ���ؼ� ox�� �ϰ�
			for(int j=0; j<jungdap.length(); j++) {
				// ����� �Է´��� �´��� ���ϸ鼭 ä���ϴ� �κ�
				if(dto.getDap().charAt(j) == jungdap.charAt(j))	{	// ���ں�
					dto.setCnt(dto.getCnt()+1);
					dto.setOx(dto.getOx() + "O");
				} else {
					dto.setOx(dto.getOx() + "X");
				}
			}
		}
	}
	
	// �޼���3 - ���
	public void output() {
		for(int i =0; i<list.size(); i++) {
			MultipleChoiceDto dto = list.get(i);
			System.out.printf("%s %s %s %d\n", 
					dto.getName(), dto.getDap(), dto.getOx(), dto.getCnt());
		}
	}

}
