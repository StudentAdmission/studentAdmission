package com.bistu.supreme.domain;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.ILoginDao;
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
	
	@Test
	public void test() {
		String login_num = "11111";
		String login_pwd = "000000";
		Map<String, Integer> map = loginDao.findLogin(login_num, login_pwd);
		System.out.println("" + map.get("login_tag"));
	}

}
