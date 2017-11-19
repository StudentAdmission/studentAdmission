package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_class_will_record表
 * */
public class ClassWillRecord {
	/**
	 * 记录id
	 * */
	private int cwrId;
	/**
	 * 班主任姓名
	 * */
	private String cwrClassMasterName;
	/**
	 * 职工号（班主任）
	 * */
	private String cwrClassMasterNum;
	/**
	 * 时间
	 * */
	private String cwrTime;
	/**
	 * 班级号
	 * */
	private String cwrClassNum;
	/**
	 * 地点
	 * */
	private String cwrLocation;
	/**
	 * 主题
	 * */
	private String cwrTheme;
	/**
	 * 应到人数
	 * */
	private int cwrShouldBeNumber;
	/**
	 * 参加人数
	 * */
	private int cwrNumberOfParticipant;
	/**
	 * 缺勤学生
	 * */
	private String cwrAbsenceStudent;
	/**
	 * 主要内容
	 * */
	private String cwrMainContent;
	
	public int getCwrId() {
		return cwrId;
	}
	public void setCwrId(int cwrId) {
		this.cwrId = cwrId;
	}
	public String getCwrClassMasterName() {
		return cwrClassMasterName;
	}
	public void setCwrClassMasterName(String cwrClassMasterName) {
		this.cwrClassMasterName = cwrClassMasterName;
	}
	public String getCwrClassMasterNum() {
		return cwrClassMasterNum;
	}
	public void setCwrClassMasterNum(String cwrClassMasterNum) {
		this.cwrClassMasterNum = cwrClassMasterNum;
	}
	public String getCwrTime() {
		return cwrTime;
	}
	public void setCwrTime(String cwrTime) {
		this.cwrTime = cwrTime;
	}
	public String getCwrClassNum() {
		return cwrClassNum;
	}
	public void setCwrClassNum(String cwrClassNum) {
		this.cwrClassNum = cwrClassNum;
	}
	public String getCwrLocation() {
		return cwrLocation;
	}
	public void setCwrLocation(String cwrLocation) {
		this.cwrLocation = cwrLocation;
	}
	public String getCwrTheme() {
		return cwrTheme;
	}
	public void setCwrTheme(String cwrTheme) {
		this.cwrTheme = cwrTheme;
	}
	public int getCwrShouldBeNumber() {
		return cwrShouldBeNumber;
	}
	public void setCwrShouldBeNumber(int cwrShouldBeNumber) {
		this.cwrShouldBeNumber = cwrShouldBeNumber;
	}
	public String getCwrAbsenceStudent() {
		return cwrAbsenceStudent;
	}
	public void setCwrAbsenceStudent(String cwrAbsenceStudent) {
		this.cwrAbsenceStudent = cwrAbsenceStudent;
	}
	public String getCwrMainContent() {
		return cwrMainContent;
	}
	public void setCwrMainContent(String cwrMainContent) {
		this.cwrMainContent = cwrMainContent;
	}
	public int getCwrNumberOfParticipant() {
		return cwrNumberOfParticipant;
	}
	public void setCwrNumberOfParticipant(int cwrNumberOfParticipant) {
		this.cwrNumberOfParticipant = cwrNumberOfParticipant;
	}
}
