package com.bistu.supreme.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.Student;

/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestClassMaster {
	@Autowired
	private IClassMasterDao classMasterDao;
	@Autowired
	private IStudentDao studentDao;
	@Test
	public void testClassNum() {
		Map<String, String> map = classMasterDao.getNameandClassNumbyNum("20090917");
		System.out.println("班主任的姓名为："+map.get("master_name")+",班主任的班级号为："+map.get("master_class_num"));
	}
	@Test
	public void test() {
		List<Student> list = studentDao.getStudentsbyClassNum(classMasterDao.getClassNumbyNum("maa"));
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getStdName());
		}
	}
}
