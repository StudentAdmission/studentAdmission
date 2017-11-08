package com.bistu.supreme.test;

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
	public void Test() {
		System.out.println(loginDao.getEmailbyNum("456"));
	}
	
	/**
	 * 测试修改密码的方法
	 * */
	@Test
	public void testRevisePwd(){
		String loginNum = "admin";
		String loginEmail = "11111111";
		String pwd = "11111111";
		String loginPortrait = "11111111";
		if(loginDao.revisePwd(loginNum, loginEmail, pwd, loginPortrait)){
			System.out.println("修改密码成功");
		}
		else
			System.out.println("修改密码失败");
	}
}
