/**
 * 
 */
package com.bistu.supreme.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IDormitoryDao;
import com.bistu.supreme.domain.Student;

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
public class TestDormitory {
	@Autowired
	IDormitoryDao dormitoryDao;

	
	/**
	 * 测试获取室友的信息（姓名，学号，电话，籍贯 ）
	 * */
	@Test
	public void testGetAllDormMessage(){
		List<Student> allDormMessageList = new ArrayList<Student>();
		String studentId = "student3";
		try{
			allDormMessageList = dormitoryDao.getAllDormMessage(studentId);
			if(!allDormMessageList.get(0).getStdNum().equals("-1")&&allDormMessageList!=null){
				for(int i=0;i<allDormMessageList.size();i++){
					Student student = allDormMessageList.get(i);
					System.out.println("宿舍名：" + student.getStdDormNum() + "   姓名：" + student.getStdName() + "   学号：" + student.getStdNum() + "   电话：" + student.getStdTele() + "   籍贯：" + student.getStdNativePlace());
				}
			}
		}catch(Exception e){
			System.out.println("该学生目前没有室友");
		}
	}
}
