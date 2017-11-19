package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.Student;
/**
 * 班主任管理控制器
 * */
@Controller
public class ClassMasterController {
	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IClassMasterDao classMasterDao;
	/**
	 * 获取班级所有学生的所有信息
	 * */
	@RequestMapping(value="/getAllClassmates",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassmates(@RequestBody String num) {
		Response response = new Response();
		String classNum = classMasterDao.getClassNumbyNum(num);
		if(classNum == null) {
			return response.failure("no_class_master_found");
		}
		else
			if(classNum.equals("-1")) {
				return response.failure("sql_exception_classNum");
			}
			else {
				List<Student> list = studentDao.getStudentsbyClassNum(classNum);
				if(list == null) {
					return response.success();
				}
				else
					if(list.get(0).getStdNum().equals("-1")) {
						return response.failure("sql_exception");
					}
					else {
						return response.success(list);
					}
			}
	}
}
