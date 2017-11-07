package com.bistu.supreme.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IStudentDao;

/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestStudent {
	@Autowired
	private IStudentDao studentDao;
	
	@Test
	public void Test() {
		System.out.println(studentDao.getStudentInfobyNum("4").getStdBirth());
	}
}
