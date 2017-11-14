package com.bistu.supreme.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.dao.IStudentMessageBoxDao;
import com.bistu.supreme.domain.Notice;

/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestStudentMessageBox {
	@Autowired
	private IStudentMessageBoxDao sMBoxDao;
	@Autowired
	private INoticeDao noticeDao;
	
	@Test
	public void Test() {
		String classNum = "软工1703";
//		sMBoxDao.createStudentMessagebyClassNum(4, classNum);
		Map<String, Object> map = sMBoxDao.getUnReadList(4);
		System.out.println(map.get("unread_num"));
	}
}
