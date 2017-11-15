package com.bistu.supreme.controller;

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
import com.bistu.supreme.domain.ClassMaster;
import com.bistu.supreme.domain.Instructor;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.Student;
/**
 * 管理员控制器
 * */
@Controller
public class AdminController {
	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IClassMasterDao classMasterDao;
	@Autowired
	private IInstructorDao instructorDao;
	
	@RequestMapping(value="/setPersonalInfo",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setPersonalInfo(@RequestBody Map<String, Object> map) {
		Response response = new Response();
		switch((int)map.get("tag")) {
		//学生类型
		case 0:
			Student student = new Student();
			student.setStdName((String)map.get("stdName"));
			student.setStdNum((String)map.get("stdNum"));
			student.setStdCollege((String)map.get("stdCollege"));
			student.setStdEducation((String)map.get("stdEducation"));
			student.setStdDormNum((String)map.get("stdDormNum"));
			student.setStdGrade((int)map.get("stdGrade"));
			student.setStdSourceOfHealth((String)map.get("stdSourceOfHealth"));
			student.setStdMajor((String)map.get("stdMajor"));
			student.setStdClassNum((String)map.get("stdClassNum"));
			student.setStdTicketNumber((long)map.get("stdTicketNumber"));
			if(studentDao.createStudent(student)) {
				return response.success();
			}
			else{
				return response.failure("create_fail");
			}
		//班主任类型
		case 1:
			ClassMaster classMaster = new ClassMaster();
			classMaster.setMasterClassNum((String)map.get("masterClassNum"));
			classMaster.setMasterCollege((String)map.get("masterCollege"));
			classMaster.setMasterGender((String)map.get("masterGender"));
			classMaster.setMasterEmail((String)map.get("masterEmail"));
			classMaster.setMasterGrade((int)map.get("masterGrade"));
			classMaster.setMasterName((String)map.get("masterName"));
			classMaster.setMasterNum((String)map.get("masterNum"));
			classMaster.setMasterTele((long)map.get("masterTele"));
			if(classMasterDao.setClassMasterInfo(classMaster)) {
				return response.success();
			}
			else {
				return response.failure("create_fail");
			}
		//辅导员类型
		case 2:
			Instructor instructor = new Instructor();
			instructor.setItrCollege((String)map.get("itrCollege"));
			instructor.setItrEmail((String)map.get("itrEmail"));
			instructor.setItrGender((String)map.get("itrGender"));
			instructor.setItrGrade((int)map.get("itrGrade"));
			instructor.setItrName((String)map.get("itrName"));
			instructor.setItrNum((String)map.get("itrNum"));
			instructor.setItrTele((long)map.get("itrTele"));
			if(instructorDao.setInstructorInfo(instructor)) {
				return response.success();
			}
			else {
				return response.failure("create_fail");
			}
		//不存在的类型
		default:
			return response.failure("no_such_type");
		}
	}
}
