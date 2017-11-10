package com.bistu.supreme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IInstructorDao;
import com.bistu.supreme.domain.ClassMaster;
import com.bistu.supreme.domain.Student;

/**
 * Spring测试框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件
 */
@ContextConfiguration("/beans.xml")
public class TestInstructor {
	@Autowired
	private IInstructorDao instructorDao;

	@Test
	public void getAllClassStudentAndClassMasterInfo() {
		List<Object> allList = instructorDao.getAllClassStudentAndClassMasterInfo();
		if (allList != null) {
			for (int i = 0; i < allList.size(); i++) {
				if (allList.get(i) instanceof Integer) {
					System.out.println("连接数据库失败");
					break;
				} else if (allList.get(i) instanceof Student) {
					Student student = (Student)allList.get(i);
					System.out.println("学生姓名：" + student.getStdName() + "学生学号：" + student.getStdNum() + student.getStdCollege());
				} else if (allList.get(i) instanceof ClassMaster) {
					ClassMaster classmaster = (ClassMaster)allList.get(i);
					System.out.println("班主任姓名：" + classmaster.getMasterName() + "班主任工号：" + classmaster.getMasterNum());
				}
			}
		}
		else
			System.out.println("连接数据库失败");
	}

}
