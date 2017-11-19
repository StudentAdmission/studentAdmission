package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.ClassMasterAttendanceRecord;

/**
 * 班主任听课记录接口
 * */
public interface IClassMasterAttendanceRecordDao {
	/**
	 * 根据班主任的工号获取班主任听课记录
	 * */
	public List<ClassMasterAttendanceRecord> getClassMasterAttendanceRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的班主任听课记录
	 * */
	public boolean createClassMasterAttendanceRecord(ClassMasterAttendanceRecord str);
	/**
	 * 根据id删除一条班主任听课记录
	 * */
	public boolean deleteClassMasterAttendanceRecordbyId(int id);
	/**
	 * 根据id修改一条班主任听课记录
	 * */
	public boolean updateClassMasterAttendanceRecordbyId(ClassMasterAttendanceRecord str);
}
