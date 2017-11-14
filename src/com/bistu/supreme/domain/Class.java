package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_class表
 * */
public class Class {
	/**
	 * 班级号
	 * */
	private String class_num;
	/**
	 * 班主任的工号
	 * */
	private String class_master_num;
	/**
	 * 班主任的姓名
	 * */
	private String class_master_name;
	/**
	 * 班级的学生人数
	 * */
	private int class_number_of_student;
	/**
	 * 班级所在的学院
	 * */
	private String class_college;
	/**
	 * 班级所在年级
	 * */
	private int class_grade;
	
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public String getClass_master_num() {
		return class_master_num;
	}
	public void setClass_master_num(String class_master_num) {
		this.class_master_num = class_master_num;
	}
	public String getClass_master_name() {
		return class_master_name;
	}
	public void setClass_master_name(String class_master_name) {
		this.class_master_name = class_master_name;
	}
	public int getClass_number_of_student() {
		return class_number_of_student;
	}
	public void setClass_number_of_student(int class_number_of_student) {
		this.class_number_of_student = class_number_of_student;
	}
	public String getClass_college() {
		return class_college;
	}
	public void setClass_college(String class_college) {
		this.class_college = class_college;
	}
	public int getClass_grade() {
		return class_grade;
	}
	public void setClass_grade(int class_grade) {
		this.class_grade = class_grade;
	}
}
