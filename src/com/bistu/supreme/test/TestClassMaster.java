package com.bistu.supreme.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.domain.ClassMaster;
/**
 * Spring测试框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载 beans配置文件
 */
@ContextConfiguration("/beans.xml")
public class TestClassMaster {
    @Autowired
    private IClassMasterDao classMasterDao;
    @Test
    public void getClassMasterByStudent() {
        String studentNum = "201701986";
        ClassMaster classMaster = classMasterDao.getClassMasterByStudent(studentNum);
        System.out.println("班主任id：" + classMaster.getMasterNum());
    }

}
