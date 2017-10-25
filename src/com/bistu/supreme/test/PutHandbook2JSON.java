package com.bistu.supreme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.bistu.supreme.dao.IHandbookDao;
import com.bistu.supreme.domain.Handbook;
import com.bistu.supreme.util.ConvertMethod;
import com.bistu.supreme.util.Write2JSON;
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class PutHandbook2JSON {
	@Autowired
	IHandbookDao handbookDao;
	
	@Test
	public void test() {
		List<Handbook> list = handbookDao.getAll();
		String str = "";
		if(list != null) {
			str = ConvertMethod.ConvertHandBookList2JSON(list);
			Write2JSON.write2Json(str);
		}
	}
	
	
}
