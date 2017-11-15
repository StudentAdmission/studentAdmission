/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.ISchoolProfileDao;
import com.bistu.supreme.domain.SchoolProfile;

/**
 * @author LIZHIWEI 2017/11/15
 *
 */
public class SchoolProfileDaoImpl implements ISchoolProfileDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public SchoolProfile getSchoolProfile() {
		// TODO Auto-generated method stub
		SchoolProfile schoolProfile = new SchoolProfile();
		String querySchoolProfile = "select * from sa_school_profile";
		try {
			schoolProfile = jdbcTemplate.queryForObject(querySchoolProfile, new SchoolProfileMapper());
			return schoolProfile;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e) {
			schoolProfile.setProfileId(-1);
			return schoolProfile;
		}
	}

	
	protected class SchoolProfileMapper implements RowMapper<SchoolProfile>{

		@Override
		public SchoolProfile mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			SchoolProfile schoolProfile = new SchoolProfile();
			schoolProfile.setProfileId(rs.getInt("profile_id"));
			schoolProfile.setProfileContent(rs.getString("profile_content"));
			return schoolProfile;
		}
		
	}
}
