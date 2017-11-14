package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_classmaster表
 * */
public class ClassMaster {
	/**
	 * 班主任的工号
	 * */
	private String masterNum;
	/**
	 * 班主任的姓名
	 * */
	private String masterName;
	/**
	 * 班主任的性别
	 * */
	private String masterGender;
	/**
	 * 班主任所在学院
	 * */
	private String masterCollege;
	/**
	 * 班主任管理的班级
	 * */
	private String masterClassNum;
	/**
	 * 班主任的联系电话
	 * */
	private int masterTele;
	/**
	 * 班主任邮箱
	 * */
	private String masterEmail;
	/**
	 * 负责的年级
	 * */
	private int masterGrade;
	public int getMasterGrade() {
		return masterGrade;
	}
	public void setMasterGrade(int masterGrade) {
		this.masterGrade = masterGrade;
	}
	public String getMasterNum() {
		return masterNum;
	}
	public void setMasterNum(String masterNum) {
		this.masterNum = masterNum;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getMasterGender() {
		return masterGender;
	}
	public void setMasterGender(String masterGender) {
		this.masterGender = masterGender;
	}
	public String getMasterCollege() {
		return masterCollege;
	}
	public void setMasterCollege(String masterCollege) {
		this.masterCollege = masterCollege;
	}
	public String getMasterClassNum() {
		return masterClassNum;
	}
	public void setMasterClassNum(String masterClassNum) {
		this.masterClassNum = masterClassNum;
	}
	public int getMasterTele() {
		return masterTele;
	}
	public void setMasterTele(int masterTele) {
		this.masterTele = masterTele;
	}
	public String getMasterEmail() {
		return masterEmail;
	}
	public void setMasterEmail(String masterEmail) {
		this.masterEmail = masterEmail;
	}
}
