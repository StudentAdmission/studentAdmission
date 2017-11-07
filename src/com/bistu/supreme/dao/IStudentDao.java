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
}
