package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_administrator表
 * */
public class Administrator {
	/**
	 * 管理员的id
	 * */
	private int adm_id;
	/**
	 * 管理员的用户名
	 * */
	private String adm_name;
	/**
	 * 管理员的密码
	 * */
	private String adm_pwd;
	public int getAdm_id() {
		return adm_id;
	}
	public void setAdm_id(int adm_id) {
		this.adm_id = adm_id;
	}
	public String getAdm_name() {
		return adm_name;
	}
	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}
	public String getAdm_pwd() {
		return adm_pwd;
	}
	public void setAdm_pwd(String adm_pwd) {
		this.adm_pwd = adm_pwd;
	}
}
