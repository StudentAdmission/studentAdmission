package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.IStudentTalkRecordDao;
import com.bistu.supreme.domain.StudentTalkRecord;


/**
 * 学生谈话管理接口实现类
 * */
@Repository
public class StudentTalkRecordDaoImpl implements IStudentTalkRecordDao{

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<StudentTalkRecord> getStudentTalkRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<StudentTalkRecord> list = null;
		String query_sql = "select * from sa_student_talk_record where str_teacher_num=?";
		try {
			list = (List<StudentTalkRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new StudentTalkRecordMapper());
			return list;
		}
		catch(Exception e) {
			list = new ArrayList<StudentTalkRecord>();
			StudentTalkRecord str = new StudentTalkRecord();
			str.setStrId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createStudentTalkRecord(StudentTalkRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_student_talk_record(str_teacher_num,"
				+ "str_student_name,str_student_num,str_time,str_location,"
				+ "str_main_content,str_solution,str_teacher_name,str_class_num) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getStrTeacherNum());
							ps.setString(2, str.getStrStudentName());
							ps.setString(3, str.getStrStudentNum());
							try {
								ps.setString(4, str.getStrTime());
							}
							catch(Exception e) {
								ps.setString(4, null);
							}
							ps.setString(5, str.getStrLocation());
							ps.setString(6, str.getStrMainContent());
							ps.setString(7, str.getStrSolution());
							ps.setString(8, str.getStrTeacherName());
							ps.setString(9, str.getStrClassNum());
						}
				
			});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteStudentTalkRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_student_talk_record where str_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateStudentTalkRecordbyId(StudentTalkRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_student_talk_record set str_teacher_num=?,"
				+ "str_student_name=?,str_student_num=?,str_time=?,str_location=?,"
				+ "str_main_content=?,str_solution=?,str_teacher_name=?,str_class_num=? "
				+ "where str_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getStrTeacherNum());
							ps.setString(2, str.getStrStudentName());
							ps.setString(3, str.getStrStudentNum());
							try {
								ps.setString(4, str.getStrTime());
							}
							catch(Exception e) {
								ps.setString(4, null);
							}
							ps.setString(5, str.getStrLocation());
							ps.setString(6, str.getStrMainContent());
							ps.setString(7, str.getStrSolution());
							ps.setString(8, str.getStrTeacherName());
							ps.setString(9, str.getStrClassNum());
							ps.setInt(10, str.getStrId());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	protected class StudentTalkRecordMapper implements RowMapper<StudentTalkRecord>{

		@Override
		public StudentTalkRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			StudentTalkRecord str = new StudentTalkRecord();
			str.setStrId(rs.getInt("str_id"));
			str.setStrClassNum(rs.getString("str_class_num"));
			str.setStrLocation(rs.getString("str_location"));
			str.setStrMainContent(rs.getString("str_main_content"));
			str.setStrSolution(rs.getString("str_solution"));
			str.setStrStudentName(rs.getString("str_student_name"));
			str.setStrStudentNum(rs.getString("str_student_num"));
			str.setStrTeacherName(rs.getString("str_teacher_name"));
			str.setStrTeacherNum(rs.getString("str_teacher_num"));
			try {
				str.setStrTime(rs.getString("str_time"));
			}
			catch(Exception e) {
				str.setStrTime(null);
			}
			return str;
		}

		
	}
}
