/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.INewsItemDao;
import com.bistu.supreme.domain.NewsItem;

/**
 * @author LIZHIWEI
 *
 */
public class NewsItemDaoImpl implements INewsItemDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * 将DataSource注入到jdbcTemplate中
	 * */
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<NewsItem> getAllNewsItem() {
		String queryGetAllNewsItem = "select * from sa_news_item ORDER BY item_priority ASC";
		List<NewsItem> newsItemList = new ArrayList<NewsItem>();
		try{
			newsItemList = jdbcTemplate.query(queryGetAllNewsItem,new NewsItemMapper());
			if(newsItemList!=null){
				return newsItemList;
			}
			else
				return null;
		}catch(Exception e){
			NewsItem newsItem = new NewsItem();
			newsItem.setItemId(-1);
			newsItemList.add(newsItem);
			return newsItemList;
		}
	}
	
	protected class NewsItemMapper implements RowMapper<NewsItem>{

		@Override
		public NewsItem mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			NewsItem newsItem = new NewsItem();
			newsItem.setItemId(rs.getInt("item_id"));
			newsItem.setItemTitle(rs.getString("item_title"));
			newsItem.setItemTime(rs.getString("item_time"));
			newsItem.setItemContent(rs.getString("item_content"));
			newsItem.setItemPriority(rs.getInt("item_priority"));
			return newsItem;
		}
		
	}

}
