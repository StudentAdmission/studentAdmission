/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IInstructorDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.ClassMaster;
import com.bistu.supreme.domain.Instructor;
import com.bistu.supreme.domain.Student;

/**
 * @author LIZHIWEI
 *
 */
public class InstructorDaoImpl implements IInstructorDao {
	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	@Autowired
	private IStudentDao allStudent;
	@Override
	/**
	 * 获取所有学生和班主任的信息
	 * */
	public List<Object> getAllClassStudentAndClassMasterInfo() {
		// TODO Auto-generated method stub
		
		List<Object> allMessageOfStudentAndClassmaster = new ArrayList<Object>();
		List<Student> allMessageOfStudent = allStudent.getAll();
		List<ClassMaster> allMessageOfClassmaster = new ArrayList<ClassMaster>();
		String querySqlOfClassmaster = "select * from sa_classmaster";
		try{
			allMessageOfClassmaster = jdbcTemplate.query(querySqlOfClassmaster, new ClassMasterMapper());
			if(allMessageOfStudent!=null){
				for(int i=0;i<allMessageOfStudent.size();i++){
					allMessageOfStudentAndClassmaster.add(allMessageOfStudent.get(i));
				}
			}
			else{
				Student student = new Student();
				student.setStdNum("-1");
				allMessageOfStudentAndClassmaster.add(student);
			}
			if(allMessageOfClassmaster!=null){
				for(int i=0;i<allMessageOfClassmaster.size();i++){
					allMessageOfStudentAndClassmaster.add(allMessageOfClassmaster.get(i));
				}
			}
			else{
				ClassMaster classmaster = new ClassMaster();
				classmaster.setMasterNum("-1");
				allMessageOfStudentAndClassmaster.add(classmaster);
			}
			return allMessageOfStudentAndClassmaster;
		}catch(Exception e){
			allMessageOfStudentAndClassmaster.add(-1);
			return allMessageOfStudentAndClassmaster;
		}
		
	}

	/**
	 * 将从数据库中获取到的班主任的所有信息进行存储到list中
	 * */
	protected class ClassMasterMapper implements RowMapper<ClassMaster>{

		@Override
		public ClassMaster mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassMaster classMaster = new ClassMaster();
			classMaster.setMasterNum(rs.getString("master_num"));
			classMaster.setMasterName(rs.getString("master_name"));
			classMaster.setMasterGender(rs.getString("master_gender"));
			classMaster.setMasterCollege(rs.getString("master_college"));
			classMaster.setMasterClassNum(rs.getString("master_class_num"));
			classMaster.setMasterTele(rs.getLong("master_tele"));
			classMaster.setMasterEmail(rs.getString("master_email"));
			return classMaster;
		}
		
	}

	@Override
	public Instructor getInstructorByStudent(String studentNum) {
		// TODO Auto-generated method stub
		String queryInstructorByStudent = "select * from sa_instructor where itr_grade = (select std_grade from sa_student where std_num = ?) and itr_college = (select std_college from sa_student where std_num = ?)";
		Instructor instructor = new Instructor();
		try {
			instructor = jdbcTemplate.queryForObject(queryInstructorByStudent, new Object[]{studentNum,studentNum},new InstructorMapper());
			if(instructor!=null) {
				return instructor;
			}
			else
				return null;
		}catch(Exception e) {
			instructor.setItrNum("-1");
			return instructor;
		}
		
	}

	protected class InstructorMapper implements RowMapper<Instructor>{

		@Override
		public Instructor mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Instructor instructor = new Instructor();
			instructor.setItrNum(rs.getString("itr_num"));
			instructor.setItrName(rs.getString("itr_name"));
			instructor.setItrGender(rs.getString("itr_gender"));
			instructor.setItrCollege(rs.getString("itr_college"));
			instructor.setItrGrade(rs.getInt("itr_grade"));
			instructor.setItrTele(rs.getLong("itr_tele"));
			instructor.setItrEmail(rs.getString("itr_email"));
			return instructor;
		}
		
	}

	@Override
	public boolean setInstructorInfo(Instructor instructor) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_instructor(itr_num,itr_name,itr_gender,itr_college,"
				+ "itr_grade,itr_tele,itr_email) values(?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql, 
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, instructor.getItrNum());
							ps.setString(2, instructor.getItrName());
							ps.setString(3, instructor.getItrGender());
							ps.setString(4, instructor.getItrCollege());
							ps.setInt(5, instructor.getItrGrade());
							ps.setLong(6, instructor.getItrTele());
							ps.setString(7, instructor.getItrEmail());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteInstructorbyNum(String num) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_instructor where itr_num=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {num});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateInstructorbyNum(Instructor instructor) {
		// TODO Auto-generated method stub
		return false;
	}
}
