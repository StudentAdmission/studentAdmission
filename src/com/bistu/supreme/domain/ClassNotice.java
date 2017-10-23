package com.bistu.supreme.domain;

import java.sql.Date;

/**
 * 对应数据库中的sa_class_notice表
 * */
public class ClassNotice {
	/**
	 * 课程通知条目的id
	 * */
	private int note_id;
	/**
	 * 课程通知条目的标题
	 * */
	private String note_title;
	/**
	 * 发布通知的班主任的工号
	 * */
	private String note_master_num;
	/**
	 * 通知的内容
	 * */
	private String note_content;
	/**
	 * 
	 * */
	private String note_efile;
	/**
	 * 发布通知的时间
	 * */
	private Date note_time;
	/**
	 * 
	 * */
	private String note_cfile;
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_master_num() {
		return note_master_num;
	}
	public void setNote_master_num(String note_master_num) {
		this.note_master_num = note_master_num;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public String getNote_efile() {
		return note_efile;
	}
	public void setNote_efile(String note_efile) {
		this.note_efile = note_efile;
	}
	public Date getNote_time() {
		return note_time;
	}
	public void setNote_time(Date note_time) {
		this.note_time = note_time;
	}
	public String getNote_cfile() {
		return note_cfile;
	}
	public void setNote_cfile(String note_cfile) {
		this.note_cfile = note_cfile;
	}
	
}
