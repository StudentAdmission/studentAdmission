package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.IHomepageReportingProcessDao;
import com.bistu.supreme.domain.HomepageReportingProcess;

/**
 * @author LIZHIWEI
 *实现获取报到流程信息的功能
 */
public class HomepageReportingProcessDaoImpl implements IHomepageReportingProcessDao {
	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	@Override
	public List<HomepageReportingProcess> getAll() {
		// TODO Auto-generated method stub
		String querySql = "select * from sa_homepage_reporting_process";
		List<HomepageReportingProcess> homepageReportingProcessList = new ArrayList<HomepageReportingProcess>();
		try{
			homepageReportingProcessList = (List<HomepageReportingProcess>)jdbcTemplate.query(querySql, new HomepageReportingProcessMapper());
		}catch(Exception e){
			HomepageReportingProcess homepageReportingProcess = new HomepageReportingProcess();
			homepageReportingProcess.setProcessId(-1);
			homepageReportingProcessList.add(homepageReportingProcess);
		}
		return homepageReportingProcessList;
	}
	
	protected class HomepageReportingProcessMapper implements RowMapper<HomepageReportingProcess>{
		public HomepageReportingProcess mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			HomepageReportingProcess homepageReportingProcess = new HomepageReportingProcess();
			homepageReportingProcess.setProcessId(rs.getInt("process_id"));
			homepageReportingProcess.setProcessItem(rs.getString("process_item"));
			homepageReportingProcess.setProcessTime(rs.getDate("process_time"));
			homepageReportingProcess.setProcessLink(rs.getString("process_link"));
			return homepageReportingProcess;
		}
	}
}
