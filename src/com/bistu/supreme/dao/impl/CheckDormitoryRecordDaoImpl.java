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

import com.bistu.supreme.dao.ICheckDormitoryRecordDao;
import com.bistu.supreme.domain.CheckDormitoryRecord;

public class CheckDormitoryRecordDaoImpl implements ICheckDormitoryRecordDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<CheckDormitoryRecord> getCheckDormitoryRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<CheckDormitoryRecord> list = null;
		String query_sql = "select * from sa_check_dormitory_record where cdr_teacher_num=?";
		try {
			list = (List<CheckDormitoryRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new CheckDormitoryRecordMapper());
			return list;
		}
		catch(Exception e) {
			list = new ArrayList<CheckDormitoryRecord>();
			CheckDormitoryRecord str = new CheckDormitoryRecord();
			str.setCdrId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createCheckDormitoryRecord(CheckDormitoryRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_check_dormitory_record("
				+ "cdr_teacher_num,"
				+ "cdr_time,"
				+ "cdr_dormitory_number,"
				+ "cdr_dormitory_situation,"
				+ "cdr_improvement_measure,"
				+ "cdr_teacher_name,"
				+ "cdr_class_num) values(?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCdrTeacherNum());
							try {
								ps.setString(2, str.getCdrTime());
							}
							catch(Exception e) {
								ps.setString(2, null);
							}
							ps.setString(3, str.getCdrDormitoryNumber());
							ps.setString(4, str.getCdrDormitorySituation());
							ps.setString(5, str.getCdrImprovementMeasure());
							ps.setString(6, str.getCdrTeacherName());
							ps.setString(7, str.getCdrClassNum());
						}
				
			});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCheckDormitoryRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_check_dormitory_record where cdr_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCheckDormitoryRecordbyId(CheckDormitoryRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_check_dormitory_record set cdr_time=?,"
				+ "cdr_dormitory_number=?,cdr_dormitory_situation=?,cdr_improvement_measure=?"
				+ " where cdr_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							try {
								ps.setString(1, str.getCdrTime());
							}
							catch(Exception e) {
								ps.setString(1, null);
							}
							ps.setString(2, str.getCdrDormitoryNumber());
							ps.setString(3, str.getCdrDormitorySituation());
							ps.setString(4, str.getCdrImprovementMeasure());
							ps.setInt(5, str.getCdrId());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	protected class CheckDormitoryRecordMapper implements RowMapper<CheckDormitoryRecord>{

		@Override
		public CheckDormitoryRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			CheckDormitoryRecord cdr = new CheckDormitoryRecord();
			cdr.setCdrClassNum(rs.getString("cdr_class_num"));
			cdr.setCdrDormitoryNumber(rs.getString("cdr_dormitory_number"));
			cdr.setCdrDormitorySituation(rs.getString("cdr_dormitory_situation"));
			cdr.setCdrId(rs.getInt("cdr_id"));
			cdr.setCdrImprovementMeasure(rs.getString("cdr_improvement_measure"));
			cdr.setCdrTeacherNum(rs.getString("cdr_teacher_num"));
			try {
				cdr.setCdrTime(rs.getString("cdr_time"));
			}
			catch(Exception e) {
				cdr.setCdrTime(null);
			}
			cdr.setCdrTeacherName(rs.getString("cdr_teacher_name"));
			return cdr;
		}}
}
