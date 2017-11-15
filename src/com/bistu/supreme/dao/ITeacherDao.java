package com.bistu.supreme.dao;

import java.util.Map;

/**
 * 教师管理接口
 * */
public interface ITeacherDao {
	/**
	 * 通过教师的工号获取
	 * */
	public Map<String, Object> getTeacherInfobyNum(String num);
}
