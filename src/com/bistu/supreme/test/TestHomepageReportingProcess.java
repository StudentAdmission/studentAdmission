package com.bistu.supreme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IHomepageReportingProcessDao;
import com.bistu.supreme.domain.HomepageReportingProcess;
/**
 * Spring测试框架
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件 
 * */
@ContextConfiguration("/beans.xml")
public class TestHomepageReportingProcess {
	@Autowired
	IHomepageReportingProcessDao homepageReportingProcessDao;
	
	@Test
	public void test() {
		List<HomepageReportingProcess> homepageReportingProcessList = homepageReportingProcessDao.getAll();
		if(homepageReportingProcessList!=null){
			for(int i=0;i<homepageReportingProcessList.size();i++){
				HomepageReportingProcess homepageReportingProcess = homepageReportingProcessList.get(i);
				System.out.println("id:" + homepageReportingProcess.getProcessId() + "   item" + homepageReportingProcess.getProcessItem() + "   time:" + homepageReportingProcess.getProcessTime() + "   link:" + homepageReportingProcess.getProcessLink());
			}
		}
		else
			System.out.println("no such info");
	}

}
