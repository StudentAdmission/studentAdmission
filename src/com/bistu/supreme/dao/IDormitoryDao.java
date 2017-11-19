/**
 * 
 */
package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.Student;

/**
 * @author LIZHIWEI 
 *宿舍有关的接口
 */
public interface IDormitoryDao {
	/**
	 * 获取同宿舍的舍友信息
	 * */
	public List<Student> getAllDormMessage(String studentId);
	/**
	 * 根据宿舍号获得宿舍的班级
	 * */
	public String getClassNumbyDormNum(String dormNum);
}
