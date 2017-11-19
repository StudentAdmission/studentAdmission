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
			student.setStdTele(rs.getLong("std_tele"));
			student.setStdNation(rs.getString("std_nation"));
			student.setStdAddress(rs.getString("std_address"));
			student.setStdPostCode(rs.getInt("std_post_code"));
			student.setStdIdentification(rs.getString("std_identification"));
			student.setStdEmail(rs.getString("std_email"));
			student.setStdGrade(rs.getInt("std_grade"));
			student.setStdNativePlace(rs.getString("std_native_place"));
			student.setStdFatherName(rs.getString("std_father_name"));
			student.setStdFatherTele(rs.getLong("std_father_tele"));
			student.setStdMotherName(rs.getString("std_mother_name"));
			student.setStdMotherTele(rs.getLong("std_mother_tele"));
			student.setStdPoliticalStatus(rs.getString("std_political_status"));
			//测试日期类型的转化
			try {
				student.setStdBirth(rs.getString("std_birth"));
			}
			catch(Exception  e) {
				student.setStdBirth(null);
			}
			student.setStdQQ(rs.getLong("std_qq"));
			student.setStdWechat(rs.getString("std_wechat"));
			student.setStdAccountMigration(rs.getString("std_account_migration"));
			student.setStdIdPhoto(rs.getString("std_id_photo"));
			student.setStdEducation(rs.getString("std_education"));
			student.setStdTicketNumber(rs.getLong("std_ticket_number"));
			student.setStdSourceOfHealth(rs.getString("std_source_of_health"));
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
			System.out.println(e.getMessage());
			student = new Student();
			student.setStdNum("-1");
			return student;
		}
		return student;
	}

	@Override
	public boolean updateReadTag(String num, int id) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_student_message_box "
				+ "set smb_read_tag=1 where smb_student_num=? and smb_notice_id=?";
		try {
			jdbcTemplate.update(update_sql,
					new PreparedStatementSetter() {
						@Override
						public void setValues(java.sql.PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, num);
							ps.setInt(2, id);
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
			student.setStdQQ(rs.getLong("std_qq"));
			student.setStdTele(rs.getLong("std_tele"));
			student.setStdWechat(rs.getString("std_wechat"));
			return student;
		}
		
	}

	@Override
	public boolean setStudentbyNum(Student student) {
		// TODO Auto-generated method stub
		boolean[] flag = {true, true, true, true, 
				          true, true, true, true, 
				          true, true, true, true, 
				          true, true, true, true};
		String update_sql = "update sa_student set std_num=?";
		String update_sql_e = " where std_num=?";
		String[] params = {",std_name=?",
				          ",std_gender=?",
				          ",std_tele=?",
				          ",std_nation=?",
				          ",std_email=?",
				          ",std_identification=?",
				          ",std_birth=?",
				          ",std_father_name=?",
				          ",std_father_tele=?",
				          ",std_mother_name=?",
				          ",std_mother_tele=?",
				          ",std_native_place=?",
				          ",std_address=?",
				          ",std_post_code=?",
				          ",std_qq=?",
				          ",std_wechat=?"};
		if(student.getStdName() == null||student.getStdName().equals("")) {
			flag[0] = false;
		}
        if(student.getStdGender() == null||student.getStdGender().equals("")) {
        	flag[1] = false;
		}
        if(student.getStdTele()==0) {
        	flag[2] = false;
		}
        if(student.getStdNation() == null||student.getStdNation().equals("")) {
        	flag[3] = false;
		}
        if(student.getStdEmail() == null||student.getStdEmail().equals("")) {
        	flag[4] = false;
		}
        if(student.getStdIdentification() == null||student.getStdIdentification().equals("")) {
        	flag[5] = false;
		}
        if(student.getStdBirth() == null||student.getStdBirth().equals("")) {
        	flag[6] = false;
		}
        if(student.getStdFatherName() == null||student.getStdFatherName().equals("")) {
        	flag[7] = false;
		}
        if(student.getStdFatherTele() == 0) {
        	flag[8] = false;
		}
        if(student.getStdMotherName() == null||student.getStdMotherName().equals("")) {
        	flag[9] = false;
		}
        if(student.getStdMotherTele() == 0) {
        	flag[10] = false;
		}
        if(student.getStdNativePlace() == null||student.getStdNativePlace().equals("")) {
        	flag[11] = false;
		}
        if(student.getStdAddress() == null||student.getStdAddress().equals("")) {
        	flag[12] = false;
		}
        if(student.getStdPostCode() == 0) {
        	flag[13] = false;
		}
        if(student.getStdQQ() == 0) {
        	flag[14] = false;
		}
        if(student.getStdWechat() == null||student.getStdWechat().equals("")) {
        	flag[15] = false;
		}
        
        for(int i=0;i<flag.length;i++) {
        	if(flag[i]) {
        		update_sql += params[i];
        	}
        }
        
        update_sql += update_sql_e;
        
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {
				        
				        int index = 1;

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(index++,student.getStdNum());
							if(flag[0]) {
								ps.setString(index++,student.getStdName());
							}
							if(flag[1]) {
								ps.setString(index++,student.getStdGender());
							}
							if(flag[2]) {
								ps.setLong(index++,student.getStdTele());
							}
							if(flag[3]) {
								ps.setString(index++,student.getStdNation());
							}
							if(flag[4]) {
								ps.setString(index++,student.getStdEmail());
							}
							if(flag[5]) {
								ps.setString(index++,student.getStdIdentification());
							}
							if(flag[6]) {
								ps.setString(index++,student.getStdBirth());
							}
							if(flag[7]) {
								ps.setString(index++,student.getStdFatherName());
							}
							if(flag[8]) {
								ps.setLong(index++,student.getStdFatherTele());
							}
							if(flag[9]) {
								ps.setString(index++,student.getStdMotherName());
							}
							if(flag[10]) {
								ps.setLong(index++,student.getStdMotherTele());
							}
							if(flag[11]) {
								ps.setString(index++,student.getStdNativePlace());
							}
							if(flag[12]) {
								ps.setString(index++,student.getStdAddress());
							}
							if(flag[13]) {
								ps.setInt(index++,student.getStdPostCode());
							}
							if(flag[14]) {
								ps.setLong(index++,student.getStdQQ());
							}
							if(flag[15]) {
								ps.setString(index++,student.getStdWechat());
							}
							ps.setString(index++,student.getStdNum());
						}});
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteStudentbyNum(String num) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_student where std_num=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {num});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean createStudent(Student student) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_student(std_num,std_name,std_college,"
				+ "std_major,std_class_num,std_dorm_num,std_education,"
				+ "std_ticket_number,std_source_of_health,std_grade) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement rs) throws SQLException {
							// TODO Auto-generated method stub
							rs.setString(1, student.getStdNum());
							rs.setString(2, student.getStdName());
							rs.setString(3, student.getStdCollege());
							rs.setString(4, student.getStdMajor());
							rs.setString(5, student.getStdClassNum());
							rs.setString(6, student.getStdDormNum());
							rs.setString(7, student.getStdEducation());
							rs.setLong(8, student.getStdTicketNumber());
							rs.setString(9, student.getStdSourceOfHealth());
							rs.setInt(10, student.getStdGrade());
						}}
			);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public int getStudentTag(String studentNum) {
		// TODO Auto-generated method stub
		String queryTag = "select std_reset from sa_student where std_num = ?";
		int result = 0;
		try {
			result = jdbcTemplate.queryForObject(queryTag, new Object[] {studentNum},java.lang.Integer.class);
			System.out.println("result:" + result);
			return result;
		}catch(Exception e) {
			System.out.println(e.getClass());
			return -1;
		}
	}
}
