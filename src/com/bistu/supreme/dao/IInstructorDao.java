package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.Instructor;

/**
 * 辅导员信息管理接口
 * */
public interface IInstructorDao {
	/**
	 * 通过辅导员工号获取所有班级的学生的详细信息以及班主任的信息
	 * */
	public List<Object> getAllClassStudentAndClassMasterInfo();
	
	/**
	 * 通过学生的学号获取辅导员的详细信息
	 * */
	public Instructor getInstructorByStudent(String studentNum);
	
	/**
	 * 添加一个辅导员的信息
	 * */
	public boolean setInstructorInfo(Instructor instructor);
	/**
	 * 删除一个辅导员的信息
	 * */
	public boolean deleteInstructorbyNum(String num);
	/**
	 * 修改一个学生的信息
	 * */
	public boolean updateInstructorbyNum(Instructor instructor);
	/**
	 * 通过辅导员的工号获取辅导员的姓名
	 * */
	public String getInsNamebyNum(String num);
}
