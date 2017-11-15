package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.ISchoolPhoneDao;
import com.bistu.supreme.domain.SchoolPhone;

/**
 * @author LIZHIWEI
 *
 */
public class SchoolPhoneDaoImpl implements ISchoolPhoneDao {
	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<SchoolPhone> getAllSchoolPhone() {
		// TODO Auto-generated method stub
		String querySql = "select * from sa_school_phone";
		List<SchoolPhone> schoolPhoneList = new ArrayList<SchoolPhone>();
		try{
			//查找到的学院电话号码
			schoolPhoneList = (List<SchoolPhone>)jdbcTemplate.query(querySql, new SchoolPhoneMapper());
		}catch(Exception e){
			/**
			 * 连接数据库出错的时候返回一个id为-1的SchoolPhone对象
			 * */
			SchoolPhone schoolPhone = new SchoolPhone();
			schoolPhone.setSpID(-1);
			schoolPhoneList.add(schoolPhone);
		}
		return schoolPhoneList;
	}
	
	protected class SchoolPhoneMapper implements RowMapper<SchoolPhone>{
		@Override
		public SchoolPhone mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			SchoolPhone schoolPhone = new SchoolPhone();
			schoolPhone.setSpID(rs.getInt("sp_id"));
			schoolPhone.setSpCollegeName(rs.getString("sp_college_name"));
			schoolPhone.setSpCollegePhone(rs.getLong("sp_college_phone"));
			return schoolPhone;
		}
		
	}

}
