package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.dao.IStudentMessageBoxDao;
import com.bistu.supreme.domain.StudentMessageBox;

public class StudentMessageDaoImpl implements IStudentMessageBoxDao{

	@Autowired
	private IStudentDao studentDao;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public Map<String, Object> getReadList(int noticeId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String query_sql = "select smb_student_num from sa_student_message_box where smb_notice_id=?"
				+ " and smb_read_tag=?";
		try {
			 List<String> list = (List<String>)jdbcTemplate.queryForList(query_sql,
					new Object[] {noticeId, 1} ,java.lang.String.class);
			if(list == null) {
				map.put("read_num", 0);
			}
			else {
				map.put("read_num", list.size());
			}
			map.put("read_list", list);
			return map;
		}
		catch(Exception e) {
			map.put("read_num",-1);
			return map;
		}
	}

	@Override
	public Map<String, Object> getUnReadList(int noticeId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String query_sql = "select smb_student_num from sa_student_message_box where smb_notice_id=?"
				+ " and smb_read_tag=?";
		try {
			 List<String> list = (List<String>)jdbcTemplate.queryForList(query_sql,
					new Object[] {noticeId, 0} ,java.lang.String.class);
			if(list == null) {
				map.put("unread_num", 0);
			}
			else {
				map.put("unread_num", list.size());
			}
			map.put("unread_list", list);
			return map;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			map.put("unread_num",-1);
			return map;
		}
	}

	@Override
	public int createStudentMessagebyClassNum(int noticeId, String classNum) {
		// TODO Auto-generated method stub
		List<String> list = studentDao.getStudentNumbyClassNum(classNum);
		String insert_sql = "insert into sa_student_message_box (smb_student_num,smb_notice_id) values(?,?)";
		if(list == null || list.size() == 0) {
			return 0;
		}
		else {
			if(list.get(0).equals("-1")) {
				return -1;
			}
			else {
				try {
					int[] updateCounts = jdbcTemplate.batchUpdate(insert_sql, 
							new BatchPreparedStatementSetter() {

								@Override
								public int getBatchSize() {
									// TODO Auto-generated method stub
									return list.size();
								}

								@Override
								public void setValues(PreparedStatement ps, int i) throws SQLException {
									// TODO Auto-generated method stub
									ps.setString(1, list.get(i));
									ps.setInt(2, noticeId);
								}
						
					});
					return 1;
				}
				catch(Exception e) {
					return -1;
				}
			}
		}
	}

	@Override
	public List<StudentMessageBox> getStudentNoticebyNum(String num) {
		// TODO Auto-generated method stub
		List<StudentMessageBox> list = new ArrayList<StudentMessageBox>();
		String query_sql = "select smb_notice_id,smb_read_tag from sa_student_message_box "
				+ "where smb_student_num=? order by smb_read_tag asc,smb_notice_id desc";
		try {
			list = (List<StudentMessageBox>)jdbcTemplate.query(query_sql, new Object[] {num}, new StudentMessageBoxMapper());
		    return list;
		}
		catch(Exception e) {
			StudentMessageBox smb = new StudentMessageBox();
			smb.setSmbNoticeId(-1);
			list.add(smb);
			return list;
		}
	}
	
	protected class StudentMessageBoxMapper implements RowMapper<StudentMessageBox>{

		@Override
		public StudentMessageBox mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
		    StudentMessageBox smb = new StudentMessageBox();
		    smb.setSmbNoticeId(rs.getInt("smb_notice_id"));
		    smb.setSmbReadTag(rs.getInt("smb_read_tag"));
		    return smb;
		}
	}
}
