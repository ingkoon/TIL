package com.ssafy.interest.model;

public class InterestDto {
	private String user_id;
	private String dongCode;
	public InterestDto(String user_id, String dongCode) {
		super();
		this.user_id = user_id;
		this.dongCode = dongCode;
	}
	public InterestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	@Override
	public String toString() {
		return "InterestDto [user_id=" + user_id + ", dongCode=" + dongCode + "]";
	}
	
	
}
