package com.bistu.supreme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.Student;
/**
 * 学生控制器
 * */
@Controller
public class StudentController {
	@Autowired
	private IStudentDao studentDao;
	/**
	 * 获取学生的个人信息
	 * */
	@RequestMapping(value="/getPersonalInfo",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getStudentInfo(@RequestBody String num) {
		Response response = new Response();
		Student student = studentDao.getStudentInfobyNum(num);
		if(student == null) {
			return response.failure("student_not_found");
		}
		else
			if(student.getStdNum().equals("-1")) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(student);
			}
	}
	
	/**
	 * 当学生阅读通知时，修改学生的阅读标志为已读
	 * */
	@RequestMapping(value="/updateReadTag",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateReadTag(@RequestBody String num) {
		Response response = new Response();
		if(studentDao.updateReadTag(num)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
}
