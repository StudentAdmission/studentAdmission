package com.bistu.supreme.dao;

import java.util.Map;

import com.bistu.supreme.domain.ClassMaster;

/**
 * 班主任信息管理接口
 * */
public interface IClassMasterDao {
	/**
	 * 通过工号获取教师的邮箱
	 * */
	public String getEmailbyNum(String num);
	/**
	 * 通过工号获取班主任管理的班级号
	 * */
	public String getClassNumbyNum(String num);
	/**
	 * 根据班主任的工号获取的班主任的姓名和班级号
	 * */
	public Map<String, String> getNameandClassNumbyNum(String num);
	
	/**
	 * 根据学生的学号返回班主任的详细信息
	 * */
	public ClassMaster getClassMasterByStudent(String studentNum);
}
