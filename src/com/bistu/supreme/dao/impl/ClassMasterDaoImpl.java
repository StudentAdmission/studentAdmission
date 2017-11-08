package com.bistu.supreme.dao.impl;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.IClassMasterDao;
/**
 * 班主任信息管理接口实现类
 * */
@Repository
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

}
