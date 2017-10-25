package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_handbook表
 * */
public class Handbook {
	/**
	 * 学生手册的id
	 * */
	private int hbId;
	/**
	 * 学生手册的中文名称
	 * */
	private String hbCname;
	/**
	 * 学生手册的使用年份
	 * */
	private int hbGrade;
	/**
	 * 学生手册的英文名称
	 * */
	private String hbEname;
	
	public int getHbId() {
		return hbId;
	}
	public void setHbId(int hbId) {
		this.hbId = hbId;
	}
	public String getHbCname() {
		return hbCname;
	}
	public void setHbCname(String hbCname) {
		this.hbCname = hbCname;
	}
	public int getHbGrade() {
		return hbGrade;
	}
	public void setHbGrade(int hbGrade) {
		this.hbGrade = hbGrade;
	}
	public String getHbEname() {
		return hbEname;
	}
	public void setHbEname(String hbEname) {
		this.hbEname = hbEname;
	}
}
