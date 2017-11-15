/**
 * 
 */
package com.bistu.supreme.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.bistu.supreme.dao.INewsItemDao;
import com.bistu.supreme.domain.NewsItem;

import com.bistu.supreme.util.Date2StringUtil;
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
			try{
				Map<String,String> map = Date2StringUtil.getMandD(rs.getString("item_time"));
				newsItem.setItemTime(map.get("year") + "-" +map.get("month") + "-" + map.get("day"));
			}catch(Exception e){
				newsItem.setItemTitle(null);
			}
			
			newsItem.setItemContent(rs.getString("item_content"));
			newsItem.setItemPriority(rs.getInt("item_priority"));
			return newsItem;
		}
		
	}

	@Override
	public NewsItem getOneNewsItem(int newsItemID) {
		// TODO Auto-generated method stub
		NewsItem newsItem = new NewsItem();
		String queryOneNewsItem = "select * from sa_news_item WHERE item_id = ?";
		try {
			newsItem = jdbcTemplate.queryForObject(queryOneNewsItem, new Object[]{newsItemID},new NewsItemMapper());
			if(newsItem!=null)
				return newsItem;
			else
				return null;
		}catch(Exception e) {
			newsItem.setItemId(-1);
			return newsItem;
		}
	}

	@Override
	public boolean setNewsItem(NewsItem newsItem) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into sa_news_item(item_title,item_content,item_priority) values(?,?,?)";
		try {
			jdbcTemplate.update(insert_sql,
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							// TODO Auto-generated method stub
							ps.setString(1, newsItem.getItemTitle());
							ps.setString(2, newsItem.getItemContent());
							ps.setInt(3, newsItem.getItemPriority());
						}});
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
