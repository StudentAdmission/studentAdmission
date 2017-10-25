package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IRollingGraphDao;
import com.bistu.supreme.domain.RollingGraph;;

public class RollingGraphDaoImpl implements IRollingGraphDao{
	private JdbcTemplate jdbcTemplate;
	/**
	 * DataSourceע
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<RollingGraph> findAll() {
		// TODO Auto-generated method stub
		String qurey_sql = "select * from sa_rolling_graph";
		
		
		try {
			List <RollingGraph>graph = jdbcTemplate.query(qurey_sql, 
			 new RowMapper<RollingGraph>(){

				@Override
				public RollingGraph mapRow(ResultSet rs, int rowNum) throws SQLException {
					RollingGraph g=new RollingGraph();
					
					g.setGraph_name(rs.getString("graph_name"));
					g.setGraph_id(rs.getInt("graph_id"));
					g.setGraph_prioity(rs.getInt("graph_prioity"));
					return g;
				}
				
			});
			System.out.println(graph.get(0).getGraph_name());
			return graph;
		}
		catch(Exception e) {
	                 List<RollingGraph> list=new ArrayList<RollingGraph>();
	                 list.add(new RollingGraph(-1));
						return list;
		}
	}
	
	protected class RollingGraphMapper implements RowMapper<RollingGraph>{

		@Override
		public RollingGraph mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			RollingGraph graph = new RollingGraph();
			graph.setGraph_id(rs.getInt("graph_id"));
			graph.setGraph_name(rs.getString("graph_name"));
			graph.setGraph_prioity(rs.getInt("graph_prioity"));
	
			return graph;
		}
		}

}
