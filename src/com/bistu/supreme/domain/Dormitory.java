package com.bistu.supreme.domain;

/**
 * @author LIZHIWEI
 *对应数据库中sa_dormitory表
 */
public class Dormitory {
	/**
	 * 宿舍号
	 * */
	private String dormNum;
	/**
	 * 宿舍的人数
	 * */
	private int dormNumberOfStudent;
	/**
	 * 宿舍所属的班级 
	 * */
	private String dormClassNum;
	public String getDormNum() {
		return dormNum;
	}
	public void setDormNum(String dormNum) {
		this.dormNum = dormNum;
	}
	public int getDormNumberOfStudent() {
		return dormNumberOfStudent;
	}
	public void setDormNumberOfStudent(int dormNumberOfStudent) {
		this.dormNumberOfStudent = dormNumberOfStudent;
	}
	public String getDormClassNum() {
		return dormClassNum;
	}
	public void setDormClassNum(String dormClassNum) {
		this.dormClassNum = dormClassNum;
	}
	
	
	
}
