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

import com.bistu.supreme.dao.IClassStudentAwardRecordDao;
import com.bistu.supreme.domain.ClassStudentAwardRecord;

public class ClassStudentAwardRecordDaoImpl implements IClassStudentAwardRecordDao{

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<ClassStudentAwardRecord> getClassStudentAwardRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<ClassStudentAwardRecord> list = null;
		String query_sql = "select * from sa_class_student_award_record where csar_classmaster_num=?";
		try {
			list = (List<ClassStudentAwardRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new ClassStudentAwardRecordMapper());
			return list;
		}
		catch(Exception e) {
			list = new ArrayList<ClassStudentAwardRecord>();
			ClassStudentAwardRecord str = new ClassStudentAwardRecord();
			str.setCsarId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createClassStudentAwardRecord(ClassStudentAwardRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_class_student_award_record("
				+ "csar_classmaster_num,"
				+ "csar_student_name,"
				+ "csar_student_num,"
				+ "csar_award,"
				+ "csar_time,"
				+ "csar_amount,"
				+ "csar_class_num,"
				+ "csar_classmaster_name) values(?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCsarClassMasterNum());
							ps.setString(2, str.getCsarStudentName());
							ps.setString(3, str.getCsarStudentNum());
							ps.setString(4, str.getCsarAward());
							ps.setString(5, str.getCsarTime());
							ps.setInt(6, str.getCsarAmount());
							ps.setString(7, str.getCsarClassNum());
							ps.setString(8, str.getCsarClassMasterName());
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
	public boolean deleteClassStudentAwardRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_class_student_award_record where csar_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateClassStudentAwardRecordbyId(ClassStudentAwardRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_class_student_award_record set csar_student_name=?,"
				+ "csar_award=?,csar_time=?,csar_amount=? where csar_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCsarStudentName());
							ps.setString(2, str.getCsarAward());
							try {
								ps.setString(3, str.getCsarTime());
							}
							catch(Exception e) {
								ps.setString(3, null);
							}
							ps.setInt(4, str.getCsarAmount());
							ps.setInt(5, str.getCsarId());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	protected class ClassStudentAwardRecordMapper implements RowMapper<ClassStudentAwardRecord>{

		@Override
		public ClassStudentAwardRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassStudentAwardRecord csar = new ClassStudentAwardRecord();
			csar.setCsarAmount(rs.getInt("csar_amount"));
			csar.setCsarAward(rs.getString("csar_award"));
			csar.setCsarClassMasterName(rs.getString("csar_classmaster_name"));
			csar.setCsarClassMasterNum(rs.getString("csar_classmaster_num"));
			csar.setCsarClassNum(rs.getString("csar_class_num"));
			csar.setCsarId(rs.getInt("csar_id"));
			csar.setCsarStudentName(rs.getString("csar_student_name"));
			csar.setCsarStudentNum(rs.getString("csar_student_num"));
			try {
				csar.setCsarTime(rs.getString("csar_time"));
			}
			catch(Exception e) {
				csar.setCsarTime(null);
			}
			return csar;
		}}
}
