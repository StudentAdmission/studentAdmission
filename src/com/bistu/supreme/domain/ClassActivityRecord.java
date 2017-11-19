package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_class_activity_record表
 * */
public class ClassActivityRecord {
	/**
	 * 记录id
	 * */
	private int cacrId;
	/**
	 * 班主任的工号
	 * */
	private String cacrClassMasterNum;
	/**
	 * 时间
	 * */
	private String cacrTime;
	/**
	 * 地点
	 * */
	private String cacrLocation;
	/**
	 * 应到学生人数
	 * */
	private int cacrShouldBeNumber;
	/**
	 * 缺勤学生
	 * */
	private String cacrAbsenceStudent;
	/**
	 * 主题
	 * */
	private String cacrTheme;
	/**
	 * 活动内容
	 * */
	private String cacrActivity;
	/**
	 * 总结
	 * */
	private String cacrSummary;
	/**
	 * 班主任姓名
	 * */
	private String cacrClassMasterName;
	/**
	 * 班级号
	 * */
	private String cacrClassNum;
	/**
	 * 参与学生人数
	 * */
	private int cacrNumberOfParticipant;
	
	public int getCacrId() {
		return cacrId;
	}
	public void setCacrId(int cacrId) {
		this.cacrId = cacrId;
	}
	public String getCacrClassMasterNum() {
		return cacrClassMasterNum;
	}
	public void setCacrClassMasterNum(String cacrClassMasterNum) {
		this.cacrClassMasterNum = cacrClassMasterNum;
	}
	public String getCacrTime() {
		return cacrTime;
	}
	public void setCacrTime(String cacrTime) {
		this.cacrTime = cacrTime;
	}
	public String getCacrLocation() {
		return cacrLocation;
	}
	public void setCacrLocation(String cacrLocation) {
		this.cacrLocation = cacrLocation;
	}
	public int getCacrShouldBeNumber() {
		return cacrShouldBeNumber;
	}
	public void setCacrShouldBeNumber(int cacrShouldBeNumber) {
		this.cacrShouldBeNumber = cacrShouldBeNumber;
	}
	public String getCacrAbsenceStudent() {
		return cacrAbsenceStudent;
	}
	public void setCacrAbsenceStudent(String cacrAbsenceStudent) {
		this.cacrAbsenceStudent = cacrAbsenceStudent;
	}
	public String getCacrTheme() {
		return cacrTheme;
	}
	public void setCacrTheme(String cacrTheme) {
		this.cacrTheme = cacrTheme;
	}
	public String getCacrActivity() {
		return cacrActivity;
	}
	public void setCacrActivity(String cacrActivity) {
		this.cacrActivity = cacrActivity;
	}
	public String getCacrSummary() {
		return cacrSummary;
	}
	public void setCacrSummary(String cacrSummary) {
		this.cacrSummary = cacrSummary;
	}
	public String getCacrClassMasterName() {
		return cacrClassMasterName;
	}
	public void setCacrClassMasterName(String cacrClassMasterName) {
		this.cacrClassMasterName = cacrClassMasterName;
	}
	public String getCacrClassNum() {
		return cacrClassNum;
	}
	public void setCacrClassNum(String cacrClassNum) {
		this.cacrClassNum = cacrClassNum;
	}
	public int getCacrNumberOfParticipant() {
		return cacrNumberOfParticipant;
	}
	public void setCacrNumberOfParticipant(int cacrNumberOfParticipant) {
		this.cacrNumberOfParticipant = cacrNumberOfParticipant;
	}
}
