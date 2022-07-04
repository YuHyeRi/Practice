package com.addressbook;

// ����, getter setter, ������(+super class)
public class AddressBookDto {
	
	// 1. ����
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
	
	// 4. ������ (�Է¹޴� ����)
	public AddressBookDto(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
}
