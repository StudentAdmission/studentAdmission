package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.StudentTalkRecord;

/**
 * 学生谈话记录接口
 * */
public interface IStudentTalkRecordDao {
	/**
	 * 根据班主任的工号获取学生的谈话记录
	 * */
	public List<StudentTalkRecord> getStudentTalkRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的学生谈话记录
	 * */
	public boolean createStudentTalkRecord(StudentTalkRecord str);
	/**
	 * 根据id删除一条学生谈话记录
	 * */
	public boolean deleteStudentTalkRecordbyId(int id);
	/**
	 * 根据id修改一条学生谈话记录
	 * */
	public boolean updateStudentTalkRecordbyId(StudentTalkRecord str);
}
