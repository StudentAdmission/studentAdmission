package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.ClassActivityRecord;

/**
 * 班级活动记录接口
 * */
public interface IClassActivityRecordDao {
	/**
	 * 根据班主任的工号获取班级活动记录
	 * */
	public List<ClassActivityRecord> getClassActivityRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的班级活动记录
	 * */
	public boolean createClassActivityRecord(ClassActivityRecord str);
	/**
	 * 根据id删除一条班级活动记录
	 * */
	public boolean deleteClassActivityRecordbyId(int id);
	/**
	 * 根据id修改一条班级活动记录
	 * */
	public boolean updateClassActivityRecordbyId(ClassActivityRecord str);
}
