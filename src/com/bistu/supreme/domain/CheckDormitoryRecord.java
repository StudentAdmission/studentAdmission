package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_check_dormitory_record表
 * */
public class CheckDormitoryRecord {
	/**
	 * 记录id
	 * */
	private int cdrId;
	/**
	 * 职工号（班主任或辅导员）
	 * */
	private String cdrTeacherNum;
	/**
	 * 时间
	 * */
	private String cdrTime;
	/**
	 * 宿舍号
	 * */
	private String cdrDormitoryNumber;
	/**
	 * 宿舍情况
	 * */
	private String cdrDormitorySituation;
	/**
	 * 改进措施
	 * */
	private String cdrImprovementMeasure;
	/**
	 * 班级号
	 * */
	private String cdrClassNum;
	/**
	 * 教师姓名
	 * */
	private String cdrTeacherName;
	
	public int getCdrId() {
		return cdrId;
	}
	public void setCdrId(int cdrId) {
		this.cdrId = cdrId;
	}
	public String getCdrTeacherNum() {
		return cdrTeacherNum;
	}
	public void setCdrTeacherNum(String cdrTeacherNum) {
		this.cdrTeacherNum = cdrTeacherNum;
	}
	public String getCdrTime() {
		return cdrTime;
	}
	public void setCdrTime(String cdrTime) {
		this.cdrTime = cdrTime;
	}
	public String getCdrDormitoryNumber() {
		return cdrDormitoryNumber;
	}
	public void setCdrDormitoryNumber(String cdrDormitoryNumber) {
		this.cdrDormitoryNumber = cdrDormitoryNumber;
	}
	public String getCdrDormitorySituation() {
		return cdrDormitorySituation;
	}
	public void setCdrDormitorySituation(String cdrDormitorySituation) {
		this.cdrDormitorySituation = cdrDormitorySituation;
	}
	public String getCdrImprovementMeasure() {
		return cdrImprovementMeasure;
	}
	public void setCdrImprovementMeasure(String cdrImprovementMeasure) {
		this.cdrImprovementMeasure = cdrImprovementMeasure;
	}
	public String getCdrClassNum() {
		return cdrClassNum;
	}
	public void setCdrClassNum(String cdrClassNum) {
		this.cdrClassNum = cdrClassNum;
	}
	public String getCdrTeacherName() {
		return cdrTeacherName;
	}
	public void setCdrTeacherName(String cdrTeacherName) {
		this.cdrTeacherName = cdrTeacherName;
	}
}
