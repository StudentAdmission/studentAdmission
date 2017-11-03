package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bistu.supreme.domain.CommonProblem;
import com.bistu.supreme.dao.ICommonProblemDao;
@Repository 
public class CommonProblemDaoImpl implements ICommonProblemDao{

	private JdbcTemplate jdbcTemplate;
	/*数据库模板*/
	
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<CommonProblem> findAll() {
		// TODO Auto-generated method stub
		String query_sql = "select * from sa_common_problem";
		List <CommonProblem> graph=new ArrayList<CommonProblem>();
		
		try {
			graph = (List<CommonProblem>)jdbcTemplate.query(query_sql, new CommonProblemMapper());
			
		}
		catch(Exception e) {
	                 List<CommonProblem> list=new ArrayList<CommonProblem>();
	                 list.add(new CommonProblem(-1));
	                 System.out.println("error");
						return list;
		}
		return graph;
	}
	
	protected class CommonProblemMapper implements RowMapper<CommonProblem>{
		public CommonProblem mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommonProblem g=new CommonProblem();
			g.setCPid(rs.getInt("cp_id"));
			g.setCPquestion(rs.getString("cp_question"));
			g.setCPanswer(rs.getString("cp_answer"));
			g.setCPWebLinks(rs.getString("cp_web_links"));
			System.out.println(g.getCPanswer());
			return g;
		}
	}
	
}
