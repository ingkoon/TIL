package com.ssafy.member.model;

public class Member {

	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private int age;
	private String role;
	private int delflag;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String userId, String userName, String userPwd, String email, int age, String role, int delflag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.age = age;
		this.role = role;
		this.delflag = delflag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", email=" + email
				+ ", age=" + age + ", role=" + role + ", delflag=" + delflag + "]";
	}
	
	
	
	
}
