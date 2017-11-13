package com.bistu.supreme.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IStudentTalkRecordDao;
import com.bistu.supreme.domain.StudentTalkRecord;

/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestStudentTalkRecord {
	@Autowired
	private IStudentTalkRecordDao strDao;
	@Test
	public void Test() {
		StudentTalkRecord str = new StudentTalkRecord();
		str.setStrClassNum("软工1701");
		str.setStrLocation("教二-311");
		str.setStrMainContent("好好学习！");
		str.setStrSolution("应该好好学习");
		str.setStrStudentName("杨佳佳");
		str.setStrTeacherNum("20090917");
		str.setStrTime("2017-01-01 11:11:11");
		strDao.createStudentTalkRecord(str);
	}
}
