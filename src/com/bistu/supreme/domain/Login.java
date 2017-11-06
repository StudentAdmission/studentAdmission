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
	/**
	 * 登录20分钟后的时间
	 * */
	private String loginTime;
	/**
	 * 登录邮箱
	 * */
	private String loginEmail;
	/**
	 * 登录头像
	 * */
	private String loginPortrait;
	
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
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginPortrait() {
		return loginPortrait;
	}
	public void setLoginPortrait(String loginPortrait) {
		this.loginPortrait = loginPortrait;
	}
}
