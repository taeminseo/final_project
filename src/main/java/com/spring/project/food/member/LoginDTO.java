package com.spring.project.food.member;

public class LoginDTO {
	private String member_id;
	private long member_num;
	private String pw;
	private String zipcode;
	private String address;
	private String address2;
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public long getMember_num() {
		return member_num;
	}
	public void setMember_num(long member_num) {
		this.member_num = member_num;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	

	
	
}
