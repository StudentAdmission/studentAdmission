/**
 * 
 */
package com.bistu.supreme.dao;

import java.sql.Date;

/**
 * @author LIZHIWEI
 *
 */
public interface IClassNoticeDao {
	public int addClassNotice(String noteTitle,String noteTeachweNum,String noteContent,String noteTargetClass);
}
