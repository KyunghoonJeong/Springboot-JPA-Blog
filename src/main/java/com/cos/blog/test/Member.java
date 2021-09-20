package com.cos.blog.test;

public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	//private는 이 값들을 직접 바꿀 수 없고 메소드를 통해서 변경할 수 있게끔 함. 그렇게 하기 위해서 게터 세터를 사용
	
	
	
	
	public int getId() {
		return id;
	}
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

}
