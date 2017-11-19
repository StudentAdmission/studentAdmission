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

import com.bistu.supreme.dao.IClassMasterAttendanceRecordDao;
import com.bistu.supreme.domain.ClassMasterAttendanceRecord;

public class ClassMasterAttendanceRecordDaoImpl implements IClassMasterAttendanceRecordDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<ClassMasterAttendanceRecord> getClassMasterAttendanceRecordbyClassmasterNum(String num) {
		// TODO Auto-generated method stub
		List<ClassMasterAttendanceRecord> list = null;
		String query_sql = "select * from sa_classmaster_attendance_record where car_classmaster_num=?";
		try {
			list = (List<ClassMasterAttendanceRecord>)jdbcTemplate.query(query_sql, new Object[] {num}, 
					new ClassMasterAttendanceRecordMapper());
			return list;
		}
		catch(Exception e) {
			list = new ArrayList<ClassMasterAttendanceRecord>();
			ClassMasterAttendanceRecord str = new ClassMasterAttendanceRecord();
			str.setCarId(-1);
			list.add(str);
			return list;
		}
	}

	@Override
	public boolean createClassMasterAttendanceRecord(ClassMasterAttendanceRecord str) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_classmaster_attendance_record("
				+ "car_classmaster_num,"
				+ "car_time,"
				+ "car_classroom,"
				+ "car_course_title,"
				+ "car_teacher_num,"
				+ "car_should_be_number,"
				+ "car_reached_the_number,"
				+ "car_situation_record,"
				+ "car_classmaster_name) values(?,?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, str.getCarClassMasterNum());
							try {
								ps.setString(2, str.getCarTime());
							}
							catch(Exception e) {
								ps.setString(2, null);
							}
							ps.setString(3, str.getCarClassRoom());
							ps.setString(4, str.getCarCourseTitle());
							ps.setString(5, str.getCarTeacherNum());
							ps.setInt(6, str.getCarShouldBeNumber());
							ps.setInt(7, str.getCarReachedTheNumber());
							ps.setString(8, str.getCarSituationRecord());
							ps.setString(9, str.getCarClassMasterName());
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
	public boolean deleteClassMasterAttendanceRecordbyId(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_classmaster_attendance_record where car_id=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {id});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateClassMasterAttendanceRecordbyId(ClassMasterAttendanceRecord str) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_classmaster_attendance_record set car_time=?,"
				+ "car_classroom=?,car_course_title=?,car_should_be_number=?,"
				+ "car_reached_the_number=?,car_situation_record=? where car_id=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							try {
								ps.setString(1, str.getCarTime());
							}
							catch(Exception e) {
								ps.setString(1, null);
							}
							ps.setString(2, str.getCarClassRoom());
							ps.setString(3, str.getCarCourseTitle());
							ps.setInt(4, str.getCarShouldBeNumber());
							ps.setInt(5, str.getCarReachedTheNumber());
							ps.setString(6, str.getCarSituationRecord());
							ps.setInt(7, str.getCarId());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	protected class ClassMasterAttendanceRecordMapper implements RowMapper<ClassMasterAttendanceRecord>{

		@Override
		public ClassMasterAttendanceRecord mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassMasterAttendanceRecord car = new ClassMasterAttendanceRecord();
			car.setCarClassMasterName(rs.getString("car_classmaster_name"));
			car.setCarClassMasterNum(rs.getString("car_classmaster_num"));
			car.setCarClassRoom(rs.getString("car_classroom"));
			car.setCarCourseTitle(rs.getString("car_course_title"));
			car.setCarId(rs.getInt("car_id"));
			car.setCarReachedTheNumber(rs.getInt("car_reached_the_number"));
			car.setCarShouldBeNumber(rs.getInt("car_should_be_number"));
			car.setCarSituationRecord(rs.getString("car_situation_record"));
			car.setCarTeacherNum(rs.getString("car_teacher_num"));
			try {
				car.setCarTime(rs.getString("car_time"));
			}
			catch(Exception e) {
				car.setCarTime(null);
			}
			return car;
		}}
}
