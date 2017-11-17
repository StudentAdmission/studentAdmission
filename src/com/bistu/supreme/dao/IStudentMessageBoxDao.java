package com.bistu.supreme.dao;

import java.util.List;
import java.util.Map;

import com.bistu.supreme.domain.StudentMessageBox;

/**
 * 学生消息盒子接口
 * */
public interface IStudentMessageBoxDao {
	/**
	 * 获取学生已读名单及人数
	 * */
	public Map<String,Object> getReadList(int noticeId);
	/**
	 * 获取学生未读名单及人数
	 * */
	public Map<String,Object> getUnReadList(int noticeId);
	/**
	 * 为班级的所有学生添加消息盒子
	 * */
	public int createStudentMessagebyClassNum(int noticeId, List<String> list);
	/**
	 * 通过学号获得学生的个人通知
	 * */
	public List<StudentMessageBox> getStudentNoticebyNum(String num);
	/**
	 * 通过学号判断学生未读的通知数
	 * */
	public boolean hasUnread(String num);
}
