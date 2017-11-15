package com.bistu.supreme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.INewsItemDao;
import com.bistu.supreme.domain.NewsItem;
/**
 * Spring测试框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件
 */
@ContextConfiguration("/beans.xml")
public class TestNewsItem {
	@Autowired
	private INewsItemDao newsItemDao;
	@Test
	public void getAllNewsItem() {
		List<NewsItem> newsItemList = newsItemDao.getAllNewsItem();
		if(newsItemList!=null){
			for(int i=0;i<newsItemList.size();i++){
				NewsItem newsItem = newsItemList.get(i);
				System.out.println("新闻公告id：" + newsItem.getItemId() + "   新闻公告时间：" + newsItem.getItemTime() + "   新闻公告优先级：" + newsItem.getItemPriority());
			}
		}
		else
			System.out.println("连接数据库出错");
	}

	@Test
	public void getOneNewsItem(){
		int newsItemID = 1;
		NewsItem newsItem = newsItemDao.getOneNewsItem(newsItemID);
		if(newsItem!=null)
			System.out.println("ID:" + newsItem.getItemId() + "\n内容:" + newsItem.getItemContent() + "\n时间:" + newsItem.getItemTime());
		
	}
}
