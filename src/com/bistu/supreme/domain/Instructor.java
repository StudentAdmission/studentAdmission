package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_instructor表
 * */
public class Instructor {
	/**
	 * 辅导员的工号
	 * */
	private String itrNum;
	/**
	 * 辅导员的姓名
	 * */
	private String itrName;
	/**
	 * 辅导员的性别
	 * */
	private String itrGender;
	/**
	 * 辅导员所在学院
	 * */
	private String itrCollege;
	/**
	 * 辅导员的年级
	 * */
	private int itrGrade;
	/**
	 * 辅导员的电话
	 * */
	private long itrTele;
	/**
	 * 辅导员的邮箱
	 * */
	private String itrEmail;
	
	public String getItrNum() {
		return itrNum;
	}
	public void setItrNum(String itrNum) {
		this.itrNum = itrNum;
	}
	public String getItrName() {
		return itrName;
	}
	public void setItrName(String itrName) {
		this.itrName = itrName;
	}
	public String getItrGender() {
		return itrGender;
	}
	public void setItrGender(String itrGender) {
		this.itrGender = itrGender;
	}
	public String getItrCollege() {
		return itrCollege;
	}
	public void setItrCollege(String itrCollege) {
		this.itrCollege = itrCollege;
	}
	public int getItrGrade() {
		return itrGrade;
	}
	public void setItrGrade(int itrGrade) {
		this.itrGrade = itrGrade;
	}
	public long getItrTele() {
		return itrTele;
	}
	public void setItrTele(long itrTele) {
		this.itrTele = itrTele;
	}
	public String getItrEmail() {
		return itrEmail;
	}
	public void setItrEmail(String itrEmail) {
		this.itrEmail = itrEmail;
	}
}
