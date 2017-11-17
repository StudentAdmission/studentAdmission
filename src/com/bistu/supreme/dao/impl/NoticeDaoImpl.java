package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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
	 * 根据id获取消息详情
	 * */
	@Override
	public Notice getAllNoticeOfStudent(int id) {
		// TODO Auto-generated method stub
		String query_sql = "select notice_title,notice_content,notice_announcer_num,"
				+ "notice_file_c_name,notice_file_e_name from sa_notice where notice_id=?";
		try {
			Notice notice = jdbcTemplate.queryForObject(query_sql, new Object[] {id}, new NoticeMapper());
			return notice;
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			Notice notice = new Notice();
			notice.setNoticeId(-1);
			return notice;
		}
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
			notice.setNoticeTitle(rs.getString("notice_title"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeAnnouncerNum(rs.getString("notice_announcer_num"));
			notice.setNoticeFileCName(rs.getString("notice_file_c_name"));
			notice.setNoticeFileEName(rs.getString("notice_file_e_name"));
			return notice;
		}
	}
	
	protected class NoticeAllMapper implements RowMapper<Notice>{
		@Override
		public Notice mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Notice notice = new Notice();
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeFileCName(rs.getString("notice_file_c_name"));
			notice.setNoticePushTheNumber(rs.getInt("notice_push_the_number"));
			notice.setNoticeFileEName(rs.getString("notice_file_e_name"));
			notice.setNoticeReceiveClassNum(rs.getString("notice_receive_class_num"));
			return notice;
		}
	}

	/**
	 * 添加一条新的通知
	 * */
	@Override
	public boolean setNewNotice(Notice notice) {
		// TODO Auto-generated method stub
		if(notice.getNoticeFileCName() == null||notice.getNoticeFileCName().equals("")) {
			notice.setNoticeFileCName("");
		}
		if(notice.getNoticeFileEName() == null||notice.getNoticeFileEName().equals("")) {
			notice.setNoticeFileEName("");
		}
		String insert_sql = "insert into sa_notice("
				+ "notice_title,notice_content,"
				+ "notice_announcer_num,notice_file_c_name,"
				+ "notice_file_e_name,notice_receive_class_num) values(?,?,?,?,?,?)";
		
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, notice.getNoticeTitle());
							ps.setString(2, notice.getNoticeContent());
							ps.setString(3, notice.getNoticeAnnouncerNum());
							ps.setString(4, notice.getNoticeFileCName());
							ps.setString(5, notice.getNoticeFileEName());
							ps.setString(6, notice.getNoticeReceiveClassNum());
						}
				
			});
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public List<Notice> getNoticesbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select * from sa_notice where notice_announcer_num=?";
		List<Notice> getAllNotice = new ArrayList<Notice>();
		try{
			getAllNotice = jdbcTemplate.query(query_sql, new Object[] {num}, new NoticeAllMapper());
		}
		catch(Exception e){
			Notice notice = new Notice();
			notice.setNoticeId(-1);
			getAllNotice.add(notice);
			return getAllNotice;
		}
		return getAllNotice;
	}
	@Override
	public int getNoticeidbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select max(notice_id) from sa_notice where notice_announcer_num=?";
		try {
			int i = jdbcTemplate.queryForObject(query_sql, new Object[] {num}, java.lang.Integer.class);
			return i;
		}
		catch(Exception e) {
			return -1;
		}
	}
}
