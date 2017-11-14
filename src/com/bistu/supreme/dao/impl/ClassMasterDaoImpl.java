package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
