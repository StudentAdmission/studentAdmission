package com.bistu.supreme.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.ISchoolProfileDao;
import com.bistu.supreme.domain.SchoolProfile;

/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestSchoolProfile {
	@Autowired
	ISchoolProfileDao schoolProfileDao;
	@Test
	public void getSchoolProfile() {
		SchoolProfile schoolProfile = schoolProfileDao.getSchoolProfile();
		if(schoolProfile==null)
			System.out.println("数据库为空");
		else if(schoolProfile.getProfileId()!=-1) {
			System.out.println("id:" + schoolProfile.getProfileId() + "   简介:" + schoolProfile.getProfileContent());
		}
		else if(schoolProfile.getProfileId()==-1)
			System.out.println("连接数据库出错"); 
	}

}
