package com.bistu.supreme.domain;

import java.util.List;

/**
 * 对应数据库中的sa_notice表
 * */
public class Notice {
	/**
	 * 通知id
	 * */
	private int noticeId;
	/**
	 * 通知标题
	 * */
	private String noticeTitle;
	/**
	 * 通知内容
	 * */
	private String noticeContent;
	/**
	 * 通知推送人数
	 * */
	private int noticePushTheNumber;
	/**
	 * 通知已读人数
	 * */
	private int noticeReadNumber;
	/**
	 * 通知未读人数
	 * */
	private int noticeUnreadNumber;
	/**
	 * 通知发布者的职工号
	 * */
	private String noticeAnnouncerNum;
	/**
	 * 通知文件中文名
	 * */
	private String noticeFileCName;
	/**
	 * 通知文件英文名
	 * */
	private String noticeFileEName;
	/**
	 * 接收班级
	 * */
	private String noticeReceiveClassNum;
	/**
	 * 消息已读名单
	 * */
	private List<String> noticeReadList;
	/**
	 * 消息未读名单
	 * */
	private List<String> noticeUnReadList;
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getNoticePushTheNumber() {
		return noticePushTheNumber;
	}
	public void setNoticePushTheNumber(int noticePushTheNumber) {
		this.noticePushTheNumber = noticePushTheNumber;
	}
	public int getNoticeReadNumber() {
		return noticeReadNumber;
	}
	public void setNoticeReadNumber(int noticeReadNumber) {
		this.noticeReadNumber = noticeReadNumber;
	}
	public int getNoticeUnreadNumber() {
		return noticeUnreadNumber;
	}
	public void setNoticeUnreadNumber(int noticeUnreadNumber) {
		this.noticeUnreadNumber = noticeUnreadNumber;
	}
	public String getNoticeAnnouncerNum() {
		return noticeAnnouncerNum;
	}
	public void setNoticeAnnouncerNum(String noticeAnnouncerNum) {
		this.noticeAnnouncerNum = noticeAnnouncerNum;
	}
	public String getNoticeFileCName() {
		return noticeFileCName;
	}
	public void setNoticeFileCName(String noticeFileCName) {
		this.noticeFileCName = noticeFileCName;
	}
	public String getNoticeFileEName() {
		return noticeFileEName;
	}
	public void setNoticeFileEName(String noticeFileEName) {
		this.noticeFileEName = noticeFileEName;
	}
	public String getNoticeReceiveClassNum() {
		return noticeReceiveClassNum;
	}
	public void setNoticeReceiveClassNum(String noticeReceiveClassNum) {
		this.noticeReceiveClassNum = noticeReceiveClassNum;
	}
	public List<String> getNoticeReadList() {
		return noticeReadList;
	}
	public void setNoticeReadList(List<String> noticeReadList) {
		this.noticeReadList = noticeReadList;
	}
	public List<String> getNoticeUnReadList() {
		return noticeUnReadList;
	}
	public void setNoticeUnReadList(List<String> noticeUnReadList) {
		this.noticeUnReadList = noticeUnReadList;
	}
}
