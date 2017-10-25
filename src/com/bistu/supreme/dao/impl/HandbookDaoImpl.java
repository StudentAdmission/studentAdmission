package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.IHandbookDao;
import com.bistu.supreme.domain.Handbook;

/**
 * 学生手册获取接口实现类
 * */
@Repository
public class HandbookDaoImpl implements IHandbookDao{

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Handbook> getAll() {
		// TODO Auto-generated method stub
		String query_sql = "select * from sa_handbook";
		List<Handbook> list = new ArrayList<Handbook>();
		list = (List<Handbook>)jdbcTemplate.query(query_sql, new HandbookMapper());
		return list;
	}

	
	protected class  HandbookMapper implements RowMapper<Handbook>{

		@Override
		public Handbook mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			Handbook hb = new Handbook();
			hb.setHbId(rs.getInt("hb_id"));
			hb.setHbCname(rs.getString("hb_cname"));
			hb.setHbEname(rs.getString("hb_ename"));
			hb.setHbGrade(rs.getInt("hb_grade"));
			return hb;
		}
	}
}
