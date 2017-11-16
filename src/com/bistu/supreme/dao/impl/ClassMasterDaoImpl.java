package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.domain.ClassMaster;
/**
 * 班主任信息管理接口实现类
 * */
public class ClassMasterDaoImpl implements IClassMasterDao {

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
		return null;
	}

	@Override
	public String getClassNumbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select master_class_num from sa_classmaster where master_num=?";
		try {
			String classNum =(String)jdbcTemplate.queryForObject(query_sql, new Object[] {num}, java.lang.String.class);
			return classNum;
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			return "-1";
		}
	}

	@Override
	public Map<String, String> getNameandClassNumbyNum(String num) {
		// TODO Auto-generated method stub
		System.out.println("*****"+ num +"******");
		Map<String, String> map = new HashMap<String, String>();
		ClassMaster classMaster = new ClassMaster();
		String query_sql = "select master_class_num,master_name from sa_classmaster where master_num=?";
		try {
			System.out.println("***********");
			classMaster = jdbcTemplate.queryForObject(query_sql, new Object[] {num}, 
					new ClassMasterNameClassNumMapper());
			System.out.println("***********");
			map.put("master_name", classMaster.getMasterName());
			map.put("master_class_num", classMaster.getMasterClassNum());
			return map;
		}
		catch(EmptyResultDataAccessException e) {
			map.put("master_name", "0");
			return map;
		}
		catch(Exception e) {
			System.out.println(e.getClass());
			map.put("master_name","-1");
			return map;
		}
	}

	protected class ClassMasterNameClassNumMapper implements RowMapper<ClassMaster>{

		@Override
		public ClassMaster mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ClassMaster classMaster = new ClassMaster();
			classMaster.setMasterClassNum(rs.getString("master_class_num"));
			classMaster.setMasterName(rs.getString("master_name"));
			return classMaster;
		}
		
	}

	@Override
	public ClassMaster getClassMasterByStudent(String studentNum) {
		// TODO Auto-generated method stub
		ClassMaster classMaster = new ClassMaster();
		String queryMasterByStudent = "select * from sa_classmaster where master_class_num = (select std_class_num from sa_student where std_num=?)";
		try {
			classMaster = jdbcTemplate.queryForObject(queryMasterByStudent, new Object[]{studentNum},new ClassMasterMapper());
			if(classMaster!=null) {
				return classMaster;
			}
			else
				return null;
		}catch(Exception e) {
			System.out.println(e.getClass());
			classMaster.setMasterNum("-1");
			return classMaster;
		}
		
	}
	
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
			classMaster.setMasterGrade(rs.getInt("master_grade"));;
			return classMaster;
		}
		
	}

	@Override
	public boolean updateClassMasterbyNum(ClassMaster classMaster) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_classmaster set master_name=?,master_gender=?,master_college=?,"
				+ "master_class_num=?,master_tele=?,master_email=?,master_grade=? where master_num=?";
		try {
			jdbcTemplate.update(update_sql,
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, classMaster.getMasterName());
							ps.setString(2, classMaster.getMasterGender());
							ps.setString(3, classMaster.getMasterCollege());
							ps.setString(4, classMaster.getMasterClassNum());
							ps.setLong(5, classMaster.getMasterTele());
							ps.setString(6, classMaster.getMasterEmail());
							ps.setInt(7, classMaster.getMasterGrade());
							ps.setString(8, classMaster.getMasterNum());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean setClassMasterInfo(ClassMaster classMaster) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_classmaster(master_num,master_name,master_gender,"
				+ "master_college,master_class_num,master_tele,master_email,master_grade) "
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(insert_sql,
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1,classMaster.getMasterNum());
							ps.setString(2,classMaster.getMasterName());
							ps.setString(3,classMaster.getMasterGender());
							ps.setString(4,classMaster.getMasterCollege());
							ps.setString(5,classMaster.getMasterClassNum());
							ps.setLong(6,classMaster.getMasterTele());
							ps.setString(7,classMaster.getMasterEmail());
							ps.setInt(8,classMaster.getMasterGrade());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteClassMaster(String num) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from sa_classmaster where master_num=?";
		try {
			jdbcTemplate.update(delete_sql, new Object[] {num});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public String getCMNamebyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select master_name from sa_classmaster where master_num=?";
		try {
			String identity = jdbcTemplate.queryForObject(query_sql, new Object[] {num}, java.lang.String.class);
			return identity;
		}
		catch(EmptyResultDataAccessException e) {
			return "empty";
		}
		catch(Exception e) {
			return "exception";
		}
	}
}
