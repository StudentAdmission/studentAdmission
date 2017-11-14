package com.bistu.supreme.dao;

import java.util.List;
import java.util.Map;

/**
 * 班级管理接口
 * */
public interface IClassDao {
	/**
	 * 通过班主任工号查询班级的相关信息
	 * */
	public String getClassNumbyNum(String num);
	/**
	 * 通过年级和学院获得所有班级的班级号
	 * */
	public List<String> getClassNumsbyCollegeandGrade(String college, int grade);
}
