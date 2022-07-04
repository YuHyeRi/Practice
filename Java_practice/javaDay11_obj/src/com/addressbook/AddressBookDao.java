package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBookDao {
	
	List<AddressBookDto> list = new ArrayList<AddressBookDto>();

	public AddressBookDao() {
		list.add(new AddressBookDto("송강", "aaa1@naver.com", "01012341234"));
		list.add(new AddressBookDto("서강준", "aaa2@naver.com", "01012341235"));
		list.add(new AddressBookDto("박서준", "aaa3@naver.com", "01012341236"));
	}
	
	public List<AddressBookDto> getList(){
		return list;
	}
	
	public void insert(AddressBookDto dto) {
		list.add(dto);
	}
}
