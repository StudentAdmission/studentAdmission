package com.bistu.supreme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class TestStudent {
	@Autowired
	private IStudentDao studentDao;
	
	@Test
	public void Test() {
		System.out.println(studentDao.getStudentInfobyNum("201701986").getStdBirth());
	}
	
	@Test
	public void getClassMateInfo(){
		String studentNum = "201701987";
		List<Student> list = studentDao.getClassMateInfo(studentNum);
		if(list!=null) {
			if(!list.get(0).getStdNum().equals("-1")) {
				for(int i=0;i<list.size();i++) {
					Student student = list.get(i);
					System.out.println("学号：" + student.getStdNum() +  "   姓名：" + student.getStdName() +"   QQ：" + student.getStdQQ());
				}
			}
			else
				System.out.println("连接数据库出错");
		}
		else
			System.out.println("没有同班同学");
	}
	
	@Test
	public void getStudentTag(){
		int result = 0;
		//201701496，201702698
		String studentNum = "201702698";
		result = studentDao.getStudentTag(studentNum);
		if(result==1) {
			System.out.println("填写过了");
		}
		else if(result==0)
			System.out.println("没填写过了");
		else
			System.out.println("数据库连接失败");
	}
}
