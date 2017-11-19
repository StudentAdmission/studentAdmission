package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.ClassStudentAwardRecord;
/**
 * 班级学生的获奖情况接口
 * */
public interface IClassStudentAwardRecordDao {
	/**
	 * 根据班主任的工号获取班级学生的获奖情况
	 * */
	public List<ClassStudentAwardRecord> getClassStudentAwardRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的班级学生的获奖情况
	 * */
	public boolean createClassStudentAwardRecord(ClassStudentAwardRecord str);
	/**
	 * 根据id删除一条班级学生的获奖情况
	 * */
	public boolean deleteClassStudentAwardRecordbyId(int id);
	/**
	 * 根据id修改一条班级学生的获奖情况
	 * */
	public boolean updateClassStudentAwardRecordbyId(ClassStudentAwardRecord str);
}
