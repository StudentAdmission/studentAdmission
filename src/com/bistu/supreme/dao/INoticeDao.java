package com.bistu.supreme.dao;
import java.util.List;

import com.bistu.supreme.domain.Notice;
/**
 * @author LIZHIWEI
 *与通知相关的接口
 */
public interface INoticeDao {
	/**
	 * 根据id获取消息详情
	 * */
	public Notice getAllNoticeOfStudent(int id);
	/**
	 * 添加一条新的通知
	 * */
	public boolean setNewNotice(Notice notice);
	/**
	 * 通过教师的工号获取教师的相关通知
	 * */
	public List<Notice> getNoticesbyNum(String num);
}
