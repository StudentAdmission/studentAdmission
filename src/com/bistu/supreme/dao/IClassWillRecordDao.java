package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.ClassWillRecord;
/**
 * 班会记录接口
 * */
public interface IClassWillRecordDao {
	/**
	 * 根据班主任的工号获取班会记录
	 * */
	public List<ClassWillRecord> getClassWillRecordbyClassmasterNum(String num);
	/**
	 * 添加一条新的班会记录
	 * */
	public boolean createClassWillRecord(ClassWillRecord str);
	/**
	 * 根据id删除一条班会记录
	 * */
	public boolean deleteClassWillRecordbyId(int id);
	/**
	 * 根据id修改一条班会记录
	 * */
	public boolean updateClassWillRecordbyId(ClassWillRecord str);
}
