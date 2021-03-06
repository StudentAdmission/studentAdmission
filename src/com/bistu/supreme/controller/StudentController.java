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
	
	/**
	 * 根据传过来的参数修改学生信息
	 * */
	@RequestMapping(value="/setStudent",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setStudent(@RequestBody Student student) {
		Response response = new Response();
		if(studentDao.setStudentbyNum(student)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	/**
	 * 判断学生是否填写过个人信息
	 * */
	@RequestMapping(value="/getStudentTag",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getStudentTag(@RequestBody String studentNum){
		Response response = new Response();
		int result = studentDao.getStudentTag(studentNum);
		if(result==1||result==0) {
			return response.success(result);
		}
		else
			return response.failure();
	}
	
	/**
	 * 将学生的重置标志置为1
	 * */
	@RequestMapping(value="/setStudentTag",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setStudentTag(@RequestBody String num) {
		Response response = new Response();
		if(studentDao.setStudentTag(num)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	/**
	 * 辅导员获取年级专业的学生信息
	 * */
	@RequestMapping(value="/getCollegeStudents",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getCollegeStudents(@RequestBody String num) {
		Response response = new Response();
		Map<String, Object> map = new HashMap<String, Object>();
		map = instructorDao.getInstructorInfobyNum(num);
		List<Student> list = studentDao.getStudentsbyCollegeandGrade((String)map.get("college"), 
				(int)map.get("grade"));
		if(list == null||list.size() == 0) {
			return response.success("no_students");
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
