package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IDormitoryDao;
import com.bistu.supreme.domain.Student;

public class DormitoryDaoImpl implements IDormitoryDao {
	private JdbcTemplate jdbcTemplate;
	/* 数据库模板 */

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	/**
	 * 获取同宿舍舍友的信息 
	 * */
	@Override
	public List<Student> getAllDormMessage(String studentId) {
		// TODO Auto-generated method stub
		String queryDormNum = "select std_dorm_num from sa_student where std_num = ?";
		String dormNum = "";
		String queryDormMessage = "select std_dorm_num,std_name,std_num,std_tele,std_native_place from sa_student where std_dorm_num=? and std_num!=?";
		List<Student> allDormMessageList = new ArrayList<Student>();
		try{
			System.out.println("开始获取室友的信息");
			dormNum = jdbcTemplate.queryForObject(queryDormNum, new Object[]{studentId},java.lang.String.class);
			allDormMessageList = (List<Student>)jdbcTemplate.query(queryDormMessage, new Object[]{dormNum,studentId},new DormMessageMapper());
		}catch(Exception e){
			System.out.println(e.getMessage());;
			System.out.println("获取室友的信息出错");
			Student studnet = new Student();
			studnet.setStdNum("-1");
			allDormMessageList.add(studnet);
		}
		System.out.println("allDormMessageList的长度" + allDormMessageList.size());
		return allDormMessageList;
	}
	
	/**
	 * 将每一个室友的信息存储在List<Student>中
	 * */
	protected class DormMessageMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("开始对每一条个室友的信息存储到list中");
			Student student = new Student();
			student.setStdDormNum(rs.getString("std_dorm_num"));
			student.setStdName(rs.getString("std_name"));
			student.setStdNum(rs.getString("std_num"));
			student.setStdTele(rs.getLong("std_tele"));
			student.setStdNativePlace(rs.getString("std_native_place"));
			System.out.println("宿舍名：" + student.getStdDormNum() + "   姓名：" + student.getStdName() + "   学号：" + student.getStdNum() + "   电话：" + student.getStdTele() + "   籍贯：" + student.getStdNativePlace());
			return student;
		}
	}
}
