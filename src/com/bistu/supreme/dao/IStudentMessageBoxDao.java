package com.bistu.supreme.dao;

import java.util.Map;

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
	public int createStudentMessagebyClassNum(int noticeId, String classNum);
}
