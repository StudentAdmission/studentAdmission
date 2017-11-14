package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_student_massege_box表
 * */
public class StudentMessageBox {
	/**
	 * 接收消息的学生学号
	 * */
	private String smbStudentNum;
	/**
	 * 接收的消息ID
	 * */
	private String smbNoticeId;
	/**
	 * 该学生是否已阅读该消息
	 * */
	private int smbReadTag;
	
	public String getSmbStudentNum() {
		return smbStudentNum;
	}
	public void setSmbStudentNum(String smbStudentNum) {
		this.smbStudentNum = smbStudentNum;
	}
	public String getSmbNoticeId() {
		return smbNoticeId;
	}
	public void setSmbNoticeId(String smbNoticeId) {
		this.smbNoticeId = smbNoticeId;
	}
	public int getSmbReadTag() {
		return smbReadTag;
	}
	public void setSmbReadTag(int smbReadTag) {
		this.smbReadTag = smbReadTag;
	}
	
}
