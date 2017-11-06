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
import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.ILoginDao;
import com.bistu.supreme.domain.Login;
/**
 * 登录验证接口的实现类 
 * */
@Repository
public class LoginDaoImpl implements ILoginDao{
	
	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public Map<String, Integer> findLogin(String login_num, String login_pwd) {
		// TODO Auto-generated method stub
		String qurey_sql = "select login_tag,login_id from sa_login where login_pwd=? and login_num=?";
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			System.out.println("****************************");
			Login login = (Login)jdbcTemplate.queryForObject(qurey_sql, 
					new Object[] {login_pwd, login_num}, new LoginMapper());
			System.out.println(login.getLoginId() + "    " + login.getLoginTag());
			map.put("login_id", login.getLoginId());
			map.put("login_tag", login.getLoginTag());
		}
		catch(Exception e) {
			map.put("login_id", -1);
			return map;
		}
		return map;
	}
	
	protected class LoginMapper implements RowMapper<Login>{

		@Override
		public Login mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Login login = new Login();
//			login.setLoginNum(rs.getString("login_num"));
//			login.setLoginPwd(rs.getString("login_pwd"));
			login.setLoginId(rs.getInt("login_id"));
			login.setLoginTag(rs.getInt("login_tag"));
			return login;
		}}

	@Override
	public String getLoginTime(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select login_time from sa_login where login_num=?";
		String loginTime = "";
		try {
			loginTime = (String)jdbcTemplate.queryForObject(query_sql, new Object[] {num},
					java.lang.String.class);
		}
		catch(Exception e) {
			return "-1";
		}
		System.out.println(loginTime);
		return loginTime;
	}

	@Override
	public boolean updateLoginTime(String num, String time) {
		// TODO Auto-generated method stub
		String update_sql = "update sa_login set login_time=? where login_num=?";
		try {
			jdbcTemplate.update(update_sql, 
					new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, time);
					ps.setString(2, num);
				}
	        });
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public String getEmailbyNum(String num) {
		// TODO Auto-generated method stub
		String query_sql = "select login_email from sa_login where login_num=?";
		try {
			String email = (String)jdbcTemplate.queryForObject(query_sql,new Object[] {num},java.lang.String.class);
//			System.out.println("Impl中的邮箱为：" + email);
			return email;
		}
		catch(EmptyResultDataAccessException e) {
			return "empty";
		}
		catch(Exception e) {
			return "exception";
		}
	}
}
