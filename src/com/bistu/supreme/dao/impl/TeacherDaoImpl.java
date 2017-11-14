package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.ITeacherDao;
import com.bistu.supreme.domain.Teacher;;

public class TeacherDaoImpl implements ITeacherDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public Map<String, Object> getTeacherInfobyNum(String num) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String query_sql = "select tec_college,tec_grade,tec_identity "
				+ "from sa_teacher where tec_num=?";
		try {
			Teacher teacher = new Teacher();
			teacher = jdbcTemplate.queryForObject(query_sql, new Object[] {num}, new TeacherMapper());
			map.put("college", teacher.getTecCollege());
			map.put("grade", teacher.getTecGrade());
			map.put("identity", teacher.getTecIdentity());
			return map;
		}
		catch(EmptyResultDataAccessException e) {
			map.put("grade", 0);
			return map;
		}
		catch(Exception e) {
			map.put("grade", -1);
			return map;
		}
	}
	
	protected class TeacherMapper implements RowMapper<Teacher>{

		@Override
		public Teacher mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Teacher teacher = new Teacher();
			teacher.setTecCollege(rs.getString("tec_college"));
			teacher.setTecGrade(rs.getInt("tec_grade"));
			teacher.setTecIdentity(rs.getString("tec_identity"));
			return teacher;
		}}
}
