package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.Student;

/**
 * 学生信息管理接口
 * */
public interface IStudentDao {
	/**
	 * 根据学号获取学生的邮箱
	 * */
	public String getEmailbyNum(String num);
	/**
	 * 根据班级号获取班级所有学生的信息
	 * */
	public List<Student> getStudentsbyClassNum(String classNum);
	/**
	 * 获得所有学生的信息
	 * */
	public List<Student> getAll();
	/**
	 * 获取学生的个人信息
	 * */
	public Student getStudentInfobyNum(String num);
	/**
	 * 更改学生消息盒子的标志为已读
	 * */
	public boolean updateReadTag(String num);
	/**
	 * 计算班级人数
	 * */
	public int calculateNumbyClassNum(String classNum);
	/**
	 * 通过班级号获得学生的学号
	 * */
	public List<String> getStudentNumbyClassNum(String classNum);
	/**
	 * 通过学生的姓名获得学生的学号
	 * */
	public String getStudentNumbyName(String name);
}
