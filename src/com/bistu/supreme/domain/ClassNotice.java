package com.bistu.supreme.domain;

import java.sql.Date;

/**
 * 对应数据库中的sa_class_notice表
 * */
public class ClassNotice {
	/**
	 * 课程通知条目的id
	 * */
	private int noteId;
	/**
	 * 课程通知条目的标题
	 * */
	private String noteTitle;
	/**
	 * 发布通知的班主任的工号
	 * */
	private String noteTeachweNum;
	/**
	 * 通知的内容
	 * */
	private String noteContent;
	/**
	 * 
	 * */
	private String noteEfile;
	/**
	 * 发布通知的时间
	 * */
	private Date noteTime;
	/**
	 * 
	 * */
	private String noteCfile;
	
	/**
	 * 接收通知的班级
	 * */
	private String noteTargetClass;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteTeachweNum() {
		return noteTeachweNum;
	}

	public void setNoteTeachweNum(String noteTeachweNum) {
		this.noteTeachweNum = noteTeachweNum;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteEfile() {
		return noteEfile;
	}

	public void setNoteEfile(String noteEfile) {
		this.noteEfile = noteEfile;
	}

	public Date getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(Date noteTime) {
		this.noteTime = noteTime;
	}

	public String getNoteCfile() {
		return noteCfile;
	}

	public void setNoteCfile(String noteCfile) {
		this.noteCfile = noteCfile;
	}

	public String getNoteTargetClass() {
		return noteTargetClass;
	}

	public void setNoteTargetClass(String noteTargetClass) {
		this.noteTargetClass = noteTargetClass;
	}
	
	
}
