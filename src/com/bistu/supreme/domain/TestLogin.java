package com.bistu.supreme.domain;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IHandbookDao;
import com.bistu.supreme.dao.ILoginDao;
import com.bistu.supreme.domain.Handbook;
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestLogin {
	
	@Autowired
	private ILoginDao loginDao;
	@Autowired
	private IHandbookDao handbookDao;
	
	@Test
	public void test() {
		String login_num = "admin";
		String login_pwd = "670b14728ad9902aecba32e22fa4f6bd";
		Map<String, Integer> map = loginDao.findLogin(login_num, login_pwd);
		System.out.println("获得的tag值为：" + map.get("login_tag"));
	}
//	
//	@Test
//	public void test() {
//		List<Handbook> list = handbookDao.getAll();
//		System.out.println(list.get(0).getHbCname());
//	}

}
