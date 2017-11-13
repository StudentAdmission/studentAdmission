package com.bistu.supreme.dao;

import java.util.List;

/**
 * 辅导员信息管理接口
 * */
public interface IInstructorDao {
	/**
	 * 通过辅导员工号获取所有班级的学生的详细信息以及班主任的信息
	 * */
	public List<Object> getAllClassStudentAndClassMasterInfo();
}
