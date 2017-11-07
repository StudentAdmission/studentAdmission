package com.bistu.supreme.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IClassNoticeDao;

/**
 * @author LIZHIWEI
 *
 */
/**
 * Spring测试框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件
 */
@ContextConfiguration("/beans.xml")
public class TestClassNotice {
	@Autowired
	IClassNoticeDao classNoticeDao;
	@Test
	public void test() {
		int updateClassNoticeResult;
		String noteTitle = "通知";
		String noteTeachweNum = "master";
		String noteContent = "明天开会";
		String noteTargetClass = "软工1403班";
		try {
			updateClassNoticeResult = classNoticeDao.addClassNotice(noteTitle, noteTeachweNum, noteContent, noteTargetClass);
		}catch(Exception e) {
			System.out.println(e.getClass());
			updateClassNoticeResult = 0;
			System.out.print("连接数据库失败");
		}
		System.out.println(updateClassNoticeResult);
	}

}
