package com.bistu.supreme.domain;
/**
 * 对应数据库表中的sa_login
 * */
public class Login {
	/**
	 * 用户的登录id
	 * */
	private int login_id;
	/**
	 * 用户的学号（或工号）
	 * */
	private String login_num;
	/**
	 * 用户的密码
	 * */
	private String login_pwd;
	/**
	 * 用户的权限
	 * */
	private int login_tag;
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getLogin_num() {
		return login_num;
	}
	public void setLogin_num(String login_num) {
		this.login_num = login_num;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public int getLogin_tag() {
		return login_tag;
	}
	public void setLogin_tag(int login_tag) {
		this.login_tag = login_tag;
	}
	
}
