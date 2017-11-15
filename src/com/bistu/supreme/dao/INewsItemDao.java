/**
 * 
 */
package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.NewsItem;

/**
 * @author LIZHIWEI
 *对新闻公告的相关接口
 */
public interface INewsItemDao {
	/**
	 * 获取所有新闻公告的所有信息，根据优先级下降排序
	 * */
	public List<NewsItem> getAllNewsItem();
	
	/**
	 * 根据新闻公告的id获取新闻公告的详细信息
	 * */
	public NewsItem getOneNewsItem(int newsItemID);
	
}
