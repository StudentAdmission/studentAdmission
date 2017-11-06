/**
 * 
 */
package com.bistu.supreme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.ISchoolPhoneDao;
import com.bistu.supreme.domain.SchoolPhone;

/**
 * @author LIZHIWEI
 *
 */
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestSchoolPhone {
	@Autowired
	ISchoolPhoneDao schoolPhoneDao;
	@Test
	public void test() {
		List<SchoolPhone> schoolPhoneList = schoolPhoneDao.getAllSchoolPhone();
		if(schoolPhoneList!=null){
			for(int i=0;i<schoolPhoneList.size();i++){
				System.out.println("sp_id:" + schoolPhoneList.get(i).getSpID()
						+ "       sp_school_name:" + schoolPhoneList.get(i).getSpCollegeName()
						+ "       sp_school_phone:" + schoolPhoneList.get(i).getSpCollegePhone());
			}
		}
		else{
			System.out.println("connect SQL fail");
		}
	}

}
