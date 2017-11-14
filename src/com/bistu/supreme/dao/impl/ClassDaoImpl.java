package com.bistu.supreme.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bistu.supreme.dao.IClassDao;

public class ClassDaoImpl implements IClassDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public String getClassNumbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select class_num from sa_class where class_master_num=?";
		try {
			String classNum = (String)jdbcTemplate.queryForObject(query_sql, 
					new Object[] {num}, java.lang.String.class);
			return classNum;
		}
		catch(EmptyResultDataAccessException e) {
			return "0";
		}
		catch(Exception e) {
			return "-1";
		}
	}

	@Override
	public List<String> getClassNumsbyCollegeandGrade(String college, int grade) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String query_sql = "select class_num from sa_class where class_college=? and class_grade=?";
		try {
			list = (List<String>)jdbcTemplate.queryForList(query_sql, new Object[] {college, grade}, java.lang.String.class);
			return list;
		}
		catch(Exception e) {
			list.add("-1");
			return list;
		}
	}
}
