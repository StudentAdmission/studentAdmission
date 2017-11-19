package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.CheckDormitoryRecord;

/**
 * 深入宿舍情况接口
 * */
public interface ICheckDormitoryRecordDao {
	/**
	 * 根据班主任的工号获取深入宿舍情况调查表
	 * */
	public List<CheckDormitoryRecord> getCheckDormitoryRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的深入宿舍情况调查表
	 * */
	public boolean createCheckDormitoryRecord(CheckDormitoryRecord str);
	/**
	 * 根据id删除一条深入宿舍情况调查表
	 * */
	public boolean deleteCheckDormitoryRecordbyId(int id);
	/**
	 * 根据id修改一条深入宿舍情况调查表
	 * */
	public boolean updateCheckDormitoryRecordbyId(CheckDormitoryRecord str);
}
