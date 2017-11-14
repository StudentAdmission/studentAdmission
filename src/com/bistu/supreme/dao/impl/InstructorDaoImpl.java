/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
			classMaster.setMasterTele(rs.getInt("master_tele"));
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
			instructor.setItrTele(rs.getInt("itr_tele"));
			instructor.setItrEmail(rs.getString("itr_email"));
			return instructor;
		}
		
	}
}
