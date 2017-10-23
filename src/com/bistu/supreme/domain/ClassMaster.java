package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_classmaster表
 * */
public class ClassMaster {
	/**
	 * 班主任的工号
	 * */
	private String master_num;
	/**
	 * 班主任的姓名
	 * */
	private String master_name;
	/**
	 * 班主任的性别
	 * */
	private String master_gender;
	/**
	 * 班主任所在学院
	 * */
	private String master_college;
	/**
	 * 班主任管理的班级
	 * */
	private String master_class_num;
	/**
	 * 班主任的联系电话
	 * */
	private String master_tele;
	
	public String getMaster_num() {
		return master_num;
	}
	public void setMaster_num(String master_num) {
		this.master_num = master_num;
	}
	public String getMaster_name() {
		return master_name;
	}
	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}
	public String getMaster_gender() {
		return master_gender;
	}
	public void setMaster_gender(String master_gender) {
		this.master_gender = master_gender;
	}
	public String getMaster_college() {
		return master_college;
	}
	public void setMaster_college(String master_college) {
		this.master_college = master_college;
	}
	public String getMaster_class_num() {
		return master_class_num;
	}
	public void setMaster_class_num(String master_class_num) {
		this.master_class_num = master_class_num;
	}
	public String getMaster_tele() {
		return master_tele;
	}
	public void setMaster_tele(String master_tele) {
		this.master_tele = master_tele;
	}
	
}
