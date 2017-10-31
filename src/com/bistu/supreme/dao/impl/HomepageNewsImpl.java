package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.bistu.supreme.dao.IHomepageNewsDao;
import com.bistu.supreme.domain.HomepageNews;

/**
 * @author LIZHIWEI
 *
 */
public class HomepageNewsImpl implements IHomepageNewsDao {
	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	@Override
	public List<HomepageNews> getAll() {
		// TODO Auto-generated method stub
		String querySql = "select * from sa_homepage_news";
		List<HomepageNews> homepageNewsList = new ArrayList<HomepageNews>();
		homepageNewsList = (List<HomepageNews>)jdbcTemplate.query(querySql, new HomepageNewsMapper());
		return homepageNewsList;
	}
	
	protected class HomepageNewsMapper implements RowMapper<HomepageNews>{
		public HomepageNews mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			HomepageNews homepageNews = new HomepageNews();
			homepageNews.setHomepageNewsId(rs.getInt("homepage_news_id"));
			homepageNews.setHomepageNewTitle(rs.getString("homepage_news_title"));
			homepageNews.setHomepageNewsTime(rs.getDate("homepage_news_time"));
			homepageNews.setHomepageNewsLink(rs.getString("homepage_news_link"));
			return homepageNews;
		}
	}

}
