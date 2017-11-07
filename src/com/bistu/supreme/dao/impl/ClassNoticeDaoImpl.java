/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bistu.supreme.dao.IClassNoticeDao;

/**
 * @author LIZHIWEI
 *
 */
public class ClassNoticeDaoImpl implements IClassNoticeDao {
	private JdbcTemplate jdbcTemplate;
	/* 数据库模板 */

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public int addClassNotice(String noteTitle, String noteTeachweNum, String noteContent, String noteTargetClass) {
		// TODO Auto-generated method stub
		int updateClassNoticeResult;
		System.out.println("开始执行插入语句");
		String querySql = "insert into sa_class_notice(note_title,note_teachwe_num,note_content,note_target_class) values(?,?,?,?)";
		try {
			System.out.println("正在执行插入语句");
			updateClassNoticeResult = jdbcTemplate.update(querySql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, noteTitle);
					ps.setString(2, noteTeachweNum);
					ps.setString(3, noteContent);
					ps.setString(4, noteTargetClass);

				}

			});
			System.out.println("执行完插入语句");
		} catch (Exception e) {
			updateClassNoticeResult = 0;
			System.out.println("数据库连接失败");
		}
		return updateClassNoticeResult;
	}

}
