package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.domain.Notice;

/**
 * @author LIZHIWEI
 *
 */
public class NoticeDaoImpl implements INoticeDao {
	private JdbcTemplate jdbcTemplate;
	/* 数据库模板 */

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	/**
	 * 获取一个学生的所有通知
	 * */
	@Override
	public List<Notice> getAllNoticeOfStudent(String studentId) {
		// TODO Auto-generated method stub
		String querySqlGetClassNum = "select std_class_num from sa_student where std_num=?";
		String classNum="";
		String querySqlGetAllAllNoticeOfStudent = "select notice_id,notice_title,notice_announcer_name,notice_content,notice_file_c_name,notice_file_e_name from sa_notice where notice_receive_class_num = ?";
		List<Notice> getAllNotice = new ArrayList<Notice>();
		try{
			/*获取学生的班级号*/
			classNum = jdbcTemplate.queryForObject(querySqlGetClassNum, new Object[]{studentId},java.lang.String.class);
			/*获取学生的所有通知*/
			getAllNotice = jdbcTemplate.query(querySqlGetAllAllNoticeOfStudent,new Object[]{classNum}, new NoticeMapper());
		}catch(Exception e){
			Notice notice = new Notice();
			notice.setNoticeId(-1);
			getAllNotice.add(notice);
			//System.out.println("往list中添加id为-1的notice");
		}
		return getAllNotice;
	}

	/**
	 * 将从数据库中获取到的学生的所有通知进行存储
	 * 
	 **/
	protected class NoticeMapper implements RowMapper<Notice>{
		@Override
		public Notice mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			//System.out.println("将每一条记录进行存储到list中");
			Notice notice = new Notice();
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notice.setNoticeAnnouncerName(rs.getString("notice_announcer_name"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeFileCName(rs.getString("notice_file_c_name"));
			notice.setNoticeFileEName(rs.getString("notice_file_e_name"));
			return notice;
		}
	}
}
