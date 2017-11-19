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

import com.bistu.supreme.dao.IClassActivityRecordDao;
import com.bistu.supreme.domain.ClassActivityRecord;

public class ClassActivityRecordDaoImpl implements IClassActivityRecordDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<ClassActivityRecord> getClassActivityRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<ClassActivityRecord> list = null;
		String query_sql = "select * from sa_class_activity_record where cacr_classmaster_num=?";
		try {
			list = (List<ClassActivityRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new ClassActivityRecordMapper());
			return list;
		}
		catch(Exception e) {
			list = new ArrayList<ClassActivityRecord>();
			ClassActivityRecord str = new ClassActivityRecord();
			str.setCacrId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createClassActivityRecord(ClassActivityRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_class_activity_record("
				+ "cacr_classmaster_num,"
				+ "cacr_time,"
				+ "cacr_locaction,"
				+ "ccacr_should_be_number,"
				+ "cacr_absence_student,"
				+ "cacr_theme,"
				+ "cacr_activity,"
				+ "cacr_summary,"
				+ "cacr_classmaster_name,"
				+ "cacr_class_num,"
				+ "cacr_number_of_participant) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCacrClassMasterNum());
							try {
								ps.setString(2, str.getCacrTime());
							}
							catch(Exception e) {
								ps.setString(2, null);
							}
							ps.setString(3, str.getCacrLocation());
							ps.setInt(4, str.getCacrShouldBeNumber());
							ps.setString(5, str.getCacrAbsenceStudent());
							ps.setString(6, str.getCacrTheme());
							ps.setString(7, str.getCacrActivity());
							ps.setString(8, str.getCacrSummary());
							ps.setString(9, str.getCacrClassMasterName());
							ps.setString(10, str.getCacrClassNum());
							ps.setInt(11, str.getCacrNumberOfParticipant());
						}
				
			});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteClassActivityRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_class_activity_record where cacr_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateClassActivityRecordbyId(ClassActivityRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_class_activity_record set cacr_time=?,"
				+ "cacr_locaction=?,cacr_number_of_participant=?,cacr_absence_student=?,"
				+ "cacr_theme=?,cacr_activity=?,cacr_summary=? where cacr_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							try {
								ps.setString(1, str.getCacrTime());
							}
							catch(Exception e) {
								ps.setString(1, null);
							}
							ps.setString(2, str.getCacrLocation());
							ps.setInt(3, str.getCacrNumberOfParticipant());
							ps.setString(4, str.getCacrAbsenceStudent());
							ps.setString(5, str.getCacrTheme());
							ps.setString(6, str.getCacrActivity());
							ps.setString(7, str.getCacrSummary());
							ps.setInt(8, str.getCacrId());
						}});
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	protected class ClassActivityRecordMapper implements RowMapper<ClassActivityRecord>{

		@Override
		public ClassActivityRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassActivityRecord car = new ClassActivityRecord();
			car.setCacrAbsenceStudent(rs.getString("cacr_absence_student"));
			car.setCacrActivity(rs.getString("cacr_activity"));
			car.setCacrClassMasterName(rs.getString("cacr_classmaster_name"));
			car.setCacrClassMasterNum(rs.getString("cacr_classmaster_num"));
			car.setCacrClassNum(rs.getString("cacr_class_num"));
			car.setCacrId(rs.getInt("cacr_id"));
			car.setCacrLocation(rs.getString("cacr_locaction"));
			car.setCacrShouldBeNumber(rs.getInt("ccacr_should_be_number"));
			car.setCacrSummary(rs.getString("cacr_summary"));
			car.setCacrTheme(rs.getString("cacr_theme"));
			try {
				car.setCacrTime(rs.getString("cacr_time"));
			}
			catch(Exception e) {
				car.setCacrTime(null);
			}
			car.setCacrNumberOfParticipant(rs.getInt("cacr_number_of_participant"));
			return car;
		}}
}
