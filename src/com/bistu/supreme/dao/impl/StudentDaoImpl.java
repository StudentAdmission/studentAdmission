package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.Student;
/**
 * 学生信息管理接口实现类
 * */
@Repository
public class StudentDaoImpl implements IStudentDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public String getEmailbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select std_email from sa_student where std_num=?";
		try {
			String email = (String)jdbcTemplate.queryForObject(query_sql,new Object[] {num},java.lang.String.class);
			System.out.println("Impl中的邮箱为：" + email);
			return email;
		}
		catch(EmptyResultDataAccessException e) {
			return "empty";
		}
		catch(Exception e) {
			return "exception";
		}
	}

	@Override
	public List<Student> getStudentsbyClassNum(String classNum) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		String query_sql = "select * from sa_student where std_class_num=?";
		try {
			list = (List<Student>)jdbcTemplate.query(query_sql,new Object[] {classNum},new StudentMapper());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			Student student = new Student();
			student.setStdNum("-1");
			list.add(student);
			return list;
		}
		return list;
	}
	
	protected class StudentMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Student student = new Student();
			student.setStdNum(rs.getString("std_num"));
			student.setStdName(rs.getString("std_name"));
			student.setStdGender(rs.getString("std_gender"));
			student.setStdMajor(rs.getString("std_major"));
			student.setStdClassNum(rs.getString("std_class_num"));
			student.setStdDormNum(rs.getString("std_dorm_num"));
			student.setStdCollege(rs.getString("std_college"));
			student.setStdTele(rs.getInt("std_tele"));
			student.setStdNation(rs.getString("std_nation"));
			student.setStdAddress(rs.getString("std_address"));
			student.setStdPostCode(rs.getInt("std_post_code"));
			student.setStdIdentification(rs.getString("std_identification"));
			student.setStdEmail(rs.getString("std_email"));
			student.setStdGrade(rs.getInt("std_grade"));
			student.setStdNativePlace(rs.getString("std_native_place"));
			student.setStdFatherName(rs.getString("std_father_name"));
			student.setStdFatherTele(rs.getInt("std_father_tele"));
			student.setStdMotherName(rs.getString("std_mother_name"));
			student.setStdMotherTele(rs.getInt("std_mother_tele"));
			student.setStdPoliticalStatus(rs.getString("std_political_status"));
			//测试日期类型的转化
			try {
				student.setStdBirth(rs.getString("std_birth"));
			}
			catch(Exception  e) {
				student.setStdBirth(null);
			}
			student.setStdQQ(rs.getInt("std_qq"));
			student.setStdWechat(rs.getString("std_wechat"));
			student.setStdAccountMigration(rs.getString("std_account_migration"));
			student.setStdIdPhoto(rs.getString("std_id_photo"));
			student.setStdEducation(rs.getString("std_education"));
			student.setStdTicketNumber(rs.getInt("std_ticket_number"));
			student.setStdSourceOfHealth(rs.getString("std_source_of_ealth"));
			return student;
		}
		
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		String query_sql = "select * from sa_student";
		try {
			list = (List<Student>)jdbcTemplate.query(query_sql,new StudentMapper());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getClass());
			Student student = new Student();
			student.setStdNum("-1");
			list.add(student);
			return list;
		}
		return list;
	}

	@Override
	public Student getStudentInfobyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select * from sa_student where std_num=?";
		Student student = null;
		try {
			student = (Student)jdbcTemplate.queryForObject(query_sql, new Object[] {num},new StudentMapper());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			student = new Student();
			student.setStdNum("-1");
			return student;
		}
		return student;
	}

	@Override
	public boolean updateReadTag(String num) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_student_massege_box set smb_read_tag=1 where smb_student_num=?";
		try {
			jdbcTemplate.update(update_sql,
					new PreparedStatementSetter() {
						@Override
						public void setValues(java.sql.PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, num);
						}

			});
			return true;
		}
		
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public int calculateNumbyClassNum(String classNum) {
		// TODO Auto-generated method stub
		String query_sql = "select count(*) from sa_student where std_class_num=?";
		try {
			return (int)jdbcTemplate.queryForObject(query_sql, new Object[] {classNum}, java.lang.Integer.class);
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	public List<String> getStudentNumbyClassNum(String classNum) {
		// TODO Auto-generated method stub
		String query_sql = "select std_num from sa_student where std_class_num=?";
		try {
			List<String> list = jdbcTemplate.queryForList(query_sql, new Object[] {classNum}, java.lang.String.class);
			return list;
		}
		catch(Exception e) {
			List<String> list = new ArrayList<String>();
			list.add("-1");
			return list;
		}
	}

	@Override
	public String getStudentNumbyName(String name) {
		// TODO Auto-generated method stub
		String query_sql = "select std_num from sa_student where std_name=?";
		try {
			String num = jdbcTemplate.queryForObject(query_sql, new Object[] {name}, java.lang.String.class);
			return num;
		}
		catch(EmptyResultDataAccessException e) {
			return "empty";
		}
		catch(Exception e) {
			return "exception";
		}
	}

	@Override
	public List<Student> getClassMateInfo(String studentNum) {
		// TODO Auto-generated method stub
		String queryClassMate = "select * from sa_student where std_class_num = (select std_class_num from sa_student where std_num = ?) and std_num!=?";
		List<Student> classmateList = new ArrayList<Student>();
		try {
			classmateList = jdbcTemplate.query(queryClassMate,new Object[] {studentNum,studentNum},new ClassMateLittleMapper());
			if(classmateList!=null&&classmateList.size()!=0) {
				return classmateList;
			}
			else
				return null;
		}catch(Exception e) {
			Student student = new Student();
			student.setStdNum("-1");
			classmateList.add(student);
			return classmateList;
		}
	}

	protected class ClassMateLittleMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Student student = new Student();
			student.setStdNum(rs.getString("std_num"));
			student.setStdName(rs.getString("std_name"));
			student.setStdGender(rs.getString("std_gender"));
			student.setStdEmail(rs.getString("std_email"));
			student.setStdQQ(rs.getInt("std_qq"));
			student.setStdWechat(rs.getString("std_wechat"));
			return student;
		}
		
	}
}
