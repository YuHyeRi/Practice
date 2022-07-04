package com.addressbook;

// 변수, getter setter, 생성자(+super class)
public class AddressBookDto {
	
	// 1. 변수
	String name;
	String email;
	String phone;
	
	// 2. getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// 3. super class
	public AddressBookDto() {
		super();
	}
	
	// 4. 생성자 (입력받는 값만)
	public AddressBookDto(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
}
