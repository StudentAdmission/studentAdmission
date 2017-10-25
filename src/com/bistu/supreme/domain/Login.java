package com.bistu.supreme.domain;
/**
 * 对应数据库表中的sa_login
 * */
public class Login {
	/**
	 * 用户的登录id
	 * */
	private int loginId;
	/**
	 * 用户的学号（或工号）
	 * */
	private String loginNum;
	/**
	 * 用户的密码
	 * */
	private String loginPwd;
	/**
	 * 用户的权限
	 * */
	private int loginTag;
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public int getLoginTag() {
		return loginTag;
	}
	public void setLoginTag(int loginTag) {
		this.loginTag = loginTag;
	}
}
