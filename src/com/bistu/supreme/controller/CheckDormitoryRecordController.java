package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ICheckDormitoryRecordDao;
import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IDormitoryDao;
import com.bistu.supreme.dao.IInstructorDao;
import com.bistu.supreme.dao.ITeacherDao;
import com.bistu.supreme.domain.CheckDormitoryRecord;
import com.bistu.supreme.domain.Response;

@Controller
public class CheckDormitoryRecordController {
	@Autowired
	private ICheckDormitoryRecordDao cdrDao;
	@Autowired
	private IClassMasterDao cmDao;
	@Autowired
	private IDormitoryDao dormDao; 
	@Autowired
	private ITeacherDao teacherDao;
	@Autowired
	private IInstructorDao insDao;
	
	@RequestMapping(value="/setCheckDormitoryRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setCheckDormitoryRecord(@RequestBody CheckDormitoryRecord cdr) {
		Response response = new Response();
		cdr.setCdrClassNum(dormDao.getClassNumbyDormNum(cdr.getCdrDormitoryNumber()));
		switch(teacherDao.getTeacherIdentitybyNum(cdr.getCdrTeacherNum())) {
		//班主任
		case "0":
			cdr.setCdrTeacherName(cmDao.getCMNamebyNum(cdr.getCdrTeacherNum()));
			break;
		//辅导员
		case "1":
			cdr.setCdrTeacherName(insDao.getInsNamebyNum(cdr.getCdrTeacherNum()));
			break;
		default:
			return response.failure("no_such_type");
		}
		if(cdrDao.createCheckDormitoryRecord(cdr)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/deleteCheckDormitoryRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteCheckDormitoryRecord(@RequestBody int id) {
		Response response = new Response();
		if(cdrDao.deleteCheckDormitoryRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/updateCheckDormitoryRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateCheckDormitoryRecord(@RequestBody CheckDormitoryRecord cdr) {
		Response response = new Response();
		if(cdrDao.updateCheckDormitoryRecordbyId(cdr)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/getCheckDormitoryRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getCheckDormitoryRecord(@RequestBody String num) {
		Response response = new Response();
		List<CheckDormitoryRecord> list = cdrDao.getCheckDormitoryRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success("no_record_found");
		}
		else
			if(list.get(0).getCdrId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
