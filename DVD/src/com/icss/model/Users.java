package com.icss.model;

public class Users {
	private String user; //用户名
	private String pwd;  //密码
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String user, String pwd) {
		super();
		this.user = user;
		this.pwd = pwd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
