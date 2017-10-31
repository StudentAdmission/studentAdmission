package com.bistu.supreme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IHomepageNewsDao;
import com.bistu.supreme.domain.HomepageNews;
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestHomepageNews {
	@Autowired
	IHomepageNewsDao homepageNewsDao;
	@Test
	public void test() {
		List<HomepageNews> homepageNewsLists = homepageNewsDao.getAll();
		if(homepageNewsLists!=null){
			for(int i=0;i<homepageNewsLists.size();i++){
				HomepageNews homepageNews = homepageNewsLists.get(i);
				System.out.println("id:" + homepageNews.getHomepageNewsId() + "   title:" + homepageNews.getHomepageNewTitle() + "   time:" + homepageNews.getHomepageNewsTime() + "   link:" + homepageNews.getHomepageNewsLink());
			}
		}
	}

}
