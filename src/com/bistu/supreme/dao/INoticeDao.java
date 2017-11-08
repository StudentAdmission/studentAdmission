package com.bistu.supreme.dao;
import java.util.List;

import com.bistu.supreme.domain.Notice;
/**
 * @author LIZHIWEI
 *与通知相关的接口
 */
public interface INoticeDao {
	/**
	 * 获取一名学生的所有通知
	 * */
	public List<Notice> getAllNoticeOfStudent(String studentId);
}
