package com.ej.beans;

public class MemberBean {
	private String name;
	private String userid;
	private String nickname;
	private String pwd;
	private String email;
	private String phone;

	public MemberBean() {	// 기본 생성자
		super();
	}
	
public MemberBean(String name, String userid) {	
//		super();	
		this();
		this.name=name;
		this.userid=userid;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", userid=" + userid + ", nickname=" + nickname + ", pwd=" + pwd
				+ ", email=" + email + ", phone=" + phone + "]";
	}

}
