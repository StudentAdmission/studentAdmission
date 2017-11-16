package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.ISchoolAssociationsDao;
import com.bistu.supreme.domain.SchoolAssociations;

public class SchoolAssociationsDaoImpl implements ISchoolAssociationsDao{

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<SchoolAssociations> getAllInfo() {
		// TODO Auto-generated method stub
		List<SchoolAssociations> list = new ArrayList<SchoolAssociations>();
		String query_sql = "select * from sa_school_associations";
		try {
			list = (List<SchoolAssociations>)jdbcTemplate.query(query_sql, new SchoolAssociationsMapper());
			return list;
		}
		catch(Exception e) {
			SchoolAssociations sas = new SchoolAssociations();
			sas.setAssociationsId(-1);
			list.add(sas);
			return list;
		}
	}
	
	protected class SchoolAssociationsMapper implements RowMapper<SchoolAssociations>{

		@Override
		public SchoolAssociations mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			SchoolAssociations sas = new SchoolAssociations();
			sas.setAssociationsId(rs.getInt("associations_id"));
			sas.setAssociationsName(rs.getString("associations_name"));
			sas.setAssociationsGraph(rs.getString("associations_graph"));
			sas.setAssociationsIntroduction(rs.getString("associations_introduction"));
			sas.setAssociationsPriority(rs.getInt("associations_priority"));
			return sas;
		}}
}
