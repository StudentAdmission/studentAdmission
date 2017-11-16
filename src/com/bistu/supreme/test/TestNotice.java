package com.bistu.supreme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.domain.Notice;

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
public class TestNotice {
	@Autowired
	INoticeDao classNoticeDao;

//	@Test
//	public void testGetAllNoticeOfStudent() {
//		//String studentId = "4";
//		String studentId = "201701986";
//		List<Notice> allNotice = classNoticeDao.getAllNoticeOfStudent(studentId);
//		try {
//			if (allNotice.get(0).getNoticeId() != -1) {
//				for (int i = 0; i < allNotice.size(); i++) {
//					Notice notice = allNotice.get(i);
//					System.out.println("消息名称：" + notice.getNoticeTitle() + "   发布者："
//							+ "   消息内容：" + notice.getNoticeContent() + "   消息文件中文名:" + notice.getNoticeFileEName()
//							+ "   ：消息文件英文名：" + notice.getNoticeFileCName());
//				}
//			} 
//		} catch (Exception e) {
//			System.out.println("该学生目前没有通知");
//		}
//	}
}
