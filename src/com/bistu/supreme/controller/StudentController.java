package com.bistu.supreme.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IInstructorDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.dao.IStudentMessageBoxDao;
import com.bistu.supreme.domain.ClassMaster;
import com.bistu.supreme.domain.Instructor;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.Student;
/**
 * 学生控制器
 * */
@Controller
public class StudentController {
	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IClassMasterDao classmasterDao;
	@Autowired
	private IInstructorDao instructorDao;
	@Autowired
	private IStudentMessageBoxDao sMBoxDao;
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
	public Response updateReadTag(@RequestBody Map<String, Object> map) {
		Response response = new Response();
		if(studentDao.updateReadTag((String)map.get("smbStudentNum"), (int)map.get("smbNoticeId"))) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	/**
	 * 获取同班同学的基本信息，辅导员的详细信息，班主任的详细信息
	 * */
	
	@RequestMapping(value="/getClass",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClass(@RequestBody String studentNum) {
		Response response = new Response();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> studentList = studentDao.getClassMateInfo(studentNum);
		ClassMaster classmaster = classmasterDao.getClassMasterByStudent(studentNum);
		Instructor instructor = instructorDao.getInstructorByStudent(studentNum);
		map.put("classmate", studentList);
		map.put("classmaster", classmaster);
		map.put("instructor", instructor);
		return response.success(map);
	}
	/**
	 * 判断学生是否有未读消息
	 * */
	@RequestMapping(value="/hasUnread",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response hasUnread(@RequestBody String num) {
		Response response = new Response();
		if(sMBoxDao.hasUnread(num)) {
			return response.success();
		}
		else {
			return response.failure();
		}
	}
}
