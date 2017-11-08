package com.bistu.supreme.dao;
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
}
