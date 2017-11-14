package com.bistu.supreme.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.dao.IStudentTalkRecordDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.StudentTalkRecord;

@Controller
public class StudentTalkRecordController {
	@Autowired
	private IStudentTalkRecordDao strDao;
	@Autowired
	private IClassMasterDao classMasterDao;
	@Autowired
	private IStudentDao studentDao;
	
	@RequestMapping(value="/setStudentTalkRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setStudentTalkRecord(@RequestBody StudentTalkRecord str) {
		Response response = new Response();
		String teacherName = "";
		String classNum = "";
		String studentNum = "";
		System.out.println(str.getStrTeacherNum());
		Map<String, String> map = classMasterDao.getNameandClassNumbyNum(str.getStrTeacherNum());
		if(map.get("master_name").equals("0")||map.get("master_name").equals("-1")) {
			return response.failure("classmaster_not_found");
		}
		else {
			teacherName = map.get("master_name");
			classNum = map.get("master_class_num");
			studentNum = studentDao.getStudentNumbyName(str.getStrStudentName());
			str.setStrTeacherName(teacherName);
			str.setStrClassNum(classNum);
			str.setStrStudentNum(studentNum);
		}
		if(strDao.createStudentTalkRecord(str)) {
			return response.success();
		}
		else {
			return response.failure("create_fail");
		}
	}
	
	@RequestMapping(value="/deleteStudentTalkRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteStudentTalkRecord(@RequestBody int id) {
		Response response = new Response();
		if(strDao.deleteStudentTalkRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("delete_fail");
		}
	}
	
	@RequestMapping(value="/updateStudentTalkRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateStudentTalkRecord(@RequestBody StudentTalkRecord str) {
		Response response = new Response();
		if(strDao.updateStudentTalkRecordbyId(str)) {
			return response.success();
		}
		else {
			return response.failure("update_fail");
		}
	}
	
	@RequestMapping(value="/getStudentTalkRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getStudentTalkRecord(@RequestBody String num) {
		Response response = new Response();
		List<StudentTalkRecord> list = strDao.getStudentTalkRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success();
		}
		else 
			if(list.get(0).getStrId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
