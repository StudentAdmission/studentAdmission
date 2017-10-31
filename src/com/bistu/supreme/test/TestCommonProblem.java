package com.bistu.supreme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.ICommonProblemDao;
import com.bistu.supreme.domain.CommonProblem;


	/**
	 * Spring测试框架
	 * */
	@RunWith(SpringJUnit4ClassRunner.class)
	/**
	 * 加载 beans配置文件 
	 * */
	@ContextConfiguration("/beans.xml")
	public class TestCommonProblem {
		@Autowired
	private ICommonProblemDao commonProblemDao;
		@Test
		public void test() {
			List<CommonProblem> list=commonProblemDao.findAll();
			System.out.println("" +list.get(0).getCPquestion());
			System.out.println("" +list.get(0).getCPanswer());
			System.out.println("" +list.get(0).getCPWebLinks());
		}

	}
