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

import com.bistu.supreme.dao.IClassWillRecordDao;
import com.bistu.supreme.domain.ClassWillRecord;

public class ClassWillRecordDaoImpl implements IClassWillRecordDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<ClassWillRecord> getClassWillRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<ClassWillRecord> list = null;
		String query_sql = "select * from sa_class_will_record where cwr_classmaster_num=?";
		try {
			list = (List<ClassWillRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new ClassWillRecordMapper());
			return list;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			list = new ArrayList<ClassWillRecord>();
			ClassWillRecord str = new ClassWillRecord();
			str.setCwrId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createClassWillRecord(ClassWillRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_class_will_record("
				+ "cwr_classmaster_num,"
				+ "cwr_time,"
				+ "cwr_location,"
				+ "cwr_theme,"
				+ "cwr_number_of_participant,"
				+ "cwr_absence_student,"
				+ "cwr_main_content,"
				+ "cwr_classmaster_name,"
				+ "cwr_class_num) values(?,?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCwrClassMasterNum());
							try {
								ps.setString(2, str.getCwrTime());
							}
							catch(Exception e) {
								ps.setString(2, null);
							}
							ps.setString(3, str.getCwrLocation());
							ps.setString(4, str.getCwrTheme());
							ps.setInt(5, str.getCwrNumberOfParticipant());
							ps.setString(6, str.getCwrAbsenceStudent());
							ps.setString(7, str.getCwrMainContent());
							ps.setString(8, str.getCwrClassMasterName());
							ps.setString(9, str.getCwrClassNum());
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
	public boolean deleteClassWillRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_class_will_record where cwr_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateClassWillRecordbyId(ClassWillRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_class_will_record set cwr_time=?,"
				+ "cwr_location=?,cwr_theme=?,cwr_number_of_participant=?,"
				+ "cwr_absence_student=?,cwr_main_content=? where cwr_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCwrTime());
							ps.setString(2, str.getCwrLocation());
							ps.setString(3, str.getCwrTheme());
							ps.setInt(4, str.getCwrNumberOfParticipant());
							ps.setString(5, str.getCwrAbsenceStudent());
							ps.setString(6, str.getCwrMainContent());
							ps.setInt(7, str.getCwrId());
						}});
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	protected class ClassWillRecordMapper implements RowMapper<ClassWillRecord>{

		@Override
		public ClassWillRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassWillRecord cwr = new ClassWillRecord();
			cwr.setCwrClassMasterName(rs.getString("cwr_classmaster_name"));
			cwr.setCwrClassMasterNum(rs.getString("cwr_classmaster_num"));
			cwr.setCwrClassNum(rs.getString("cwr_class_num"));
			cwr.setCwrId(rs.getInt("cwr_id"));
			cwr.setCwrLocation(rs.getString("cwr_location"));
			cwr.setCwrMainContent(rs.getString("cwr_main_content"));
			cwr.setCwrNumberOfParticipant(rs.getInt("cwr_number_of_participant"));
			cwr.setCwrShouldBeNumber(rs.getInt("cwr_should_be_number"));
			cwr.setCwrTheme(rs.getString("cwr_theme"));
			try {
				cwr.setCwrTime(rs.getString("cwr_time"));
			}
			catch(Exception e) {
				cwr.setCwrTime(null);
			}
			cwr.setCwrAbsenceStudent(rs.getString("cwr_absence_student"));
			return cwr;
		}}
}
