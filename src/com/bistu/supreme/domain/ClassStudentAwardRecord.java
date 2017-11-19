package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_class_student_award_record表
 * */
public class ClassStudentAwardRecord {
	/**
	 * 记录id
	 * */
	private int csarId;
	/**
	 * 职工号（班主任）
	 * */
	private String csarClassMasterNum;
	/**
	 * 学生姓名
	 * */
	private String csarStudentName;
	/**
	 * 学生学号
	 * */
	private String csarStudentNum;
	/**
	 * 学生获奖名称
	 * */
	private String csarAward;
	/**
	 * 学生获奖时间
	 * */
	private String csarTime;
	/**
	 * 学生获奖金额
	 * */
	private int csarAmount;
	/**
	 * 学生班级
	 * */
	private String csarClassNum;
	/**
	 * 班主任姓名
	 * */
	private String csarClassMasterName;
	
	public int getCsarId() {
		return csarId;
	}
	public void setCsarId(int csarId) {
		this.csarId = csarId;
	}
	public String getCsarClassMasterNum() {
		return csarClassMasterNum;
	}
	public void setCsarClassMasterNum(String csarClassMasterNum) {
		this.csarClassMasterNum = csarClassMasterNum;
	}
	public String getCsarStudentName() {
		return csarStudentName;
	}
	public void setCsarStudentName(String csarStudentName) {
		this.csarStudentName = csarStudentName;
	}
	public String getCsarStudentNum() {
		return csarStudentNum;
	}
	public void setCsarStudentNum(String csarStudentNum) {
		this.csarStudentNum = csarStudentNum;
	}
	public String getCsarAward() {
		return csarAward;
	}
	public void setCsarAward(String csarAward) {
		this.csarAward = csarAward;
	}
	public String getCsarTime() {
		return csarTime;
	}
	public void setCsarTime(String csarTime) {
		this.csarTime = csarTime;
	}
	public int getCsarAmount() {
		return csarAmount;
	}
	public void setCsarAmount(int csarAmount) {
		this.csarAmount = csarAmount;
	}
	public String getCsarClassNum() {
		return csarClassNum;
	}
	public void setCsarClassNum(String csarClassNum) {
		this.csarClassNum = csarClassNum;
	}
	public String getCsarClassMasterName() {
		return csarClassMasterName;
	}
	public void setCsarClassMasterName(String csarClassMasterName) {
		this.csarClassMasterName = csarClassMasterName;
	}
}
