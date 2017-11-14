package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_teacher表
 * */
public class Teacher {
	/**
	 * 教师的工号
	 * */
	private String tecNum;
	/**
	 * 教师的身份
	 * */
	private String tecIdentity;
	/**
	 * 教师负责的人数
	 * */
	private int tecResponsiblePersons;
	/**
	 * 教师管理的年级
	 * */
	private int tecGrade;
	/**
	 * 教师所在的学院
	 * */
	private String tecCollege;
	
	public String getTecNum() {
		return tecNum;
	}
	public void setTecNum(String tecNum) {
		this.tecNum = tecNum;
	}
	public String getTecIdentity() {
		return tecIdentity;
	}
	public void setTecIdentity(String tecIdentity) {
		this.tecIdentity = tecIdentity;
	}
	public int getTecResponsiblePersons() {
		return tecResponsiblePersons;
	}
	public void setTecResponsiblePersons(int tecResponsiblePersons) {
		this.tecResponsiblePersons = tecResponsiblePersons;
	}
	public int getTecGrade() {
		return tecGrade;
	}
	public void setTecGrade(int tecGrade) {
		this.tecGrade = tecGrade;
	}
	public String getTecCollege() {
		return tecCollege;
	}
	public void setTecCollege(String tecCollege) {
		this.tecCollege = tecCollege;
	}
	
}
