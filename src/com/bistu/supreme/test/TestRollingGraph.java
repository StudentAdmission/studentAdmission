package com.bistu.supreme.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bistu.supreme.dao.IRollingGraphDao;
import com.bistu.supreme.domain.RollingGraph;

import java.util.List;
import java.util.Map;
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestRollingGraph {
	@Autowired
private IRollingGraphDao RollingGraphDao;
	@Test
	public void test() {
		List<RollingGraph> list=RollingGraphDao.findAll();
		System.out.println("" +list.get(0).getGraph_name());
		System.out.println("" +list.get(0).getGraph_prioity());
	}

}
