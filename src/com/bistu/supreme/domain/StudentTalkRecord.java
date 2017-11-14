package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_student_talk_record表
 * */
public class StudentTalkRecord {
	/**
	 * 学生谈话记录的id
	 * */
	private int strId;
	/**
	 * 学生谈话记录的教师工号
	 * */
	private String strTeacherNum;
	/**
	 * 学生谈话记录的学生姓名
	 * */
	private String strStudentName;
	/**
	 * 学生谈话记录的学生学号
	 * */
	private String strStudentNum;
	/**
	 * 学生谈话的时间
	 * */
	private String strTime;
	/**
	 * 学生的谈话地点
	 * */
	private String strLocation;
	/**
	 * 学生谈话的主要内容
	 * */
	private String strMainContent;
	/**
	 * 学生谈话的结果
	 * */
	private String strSolution;
	/**
	 * 谈话的教师姓名
	 * */
	private String strTeacherName;
	/**
	 * 谈话的班级号
	 * */
	private String strClassNum;
	
	public int getStrId() {
		return strId;
	}
	public void setStrId(int strId) {
		this.strId = strId;
	}
	public String getStrTeacherNum() {
		return strTeacherNum;
	}
	public void setStrTeacherNum(String strTeacherNum) {
		this.strTeacherNum = strTeacherNum;
	}
	public String getStrStudentName() {
		return strStudentName;
	}
	public void setStrStudentName(String strStudentName) {
		this.strStudentName = strStudentName;
	}
	public String getStrStudentNum() {
		return strStudentNum;
	}
	public void setStrStudentNum(String strStudentNum) {
		this.strStudentNum = strStudentNum;
	}
	public String getStrTime() {
		return strTime;
	}
	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}
	public String getStrLocation() {
		return strLocation;
	}
	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}
	public String getStrMainContent() {
		return strMainContent;
	}
	public void setStrMainContent(String strMainContent) {
		this.strMainContent = strMainContent;
	}
	public String getStrSolution() {
		return strSolution;
	}
	public void setStrSolution(String strSolution) {
		this.strSolution = strSolution;
	}
	public String getStrTeacherName() {
		return strTeacherName;
	}
	public void setStrTeacherName(String strTeacherName) {
		this.strTeacherName = strTeacherName;
	}
	public String getStrClassNum() {
		return strClassNum;
	}
	public void setStrClassNum(String strClassNum) {
		this.strClassNum = strClassNum;
	}
}
