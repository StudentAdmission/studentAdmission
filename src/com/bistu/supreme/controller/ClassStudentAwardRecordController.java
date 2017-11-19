package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IClassStudentAwardRecordDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.domain.ClassStudentAwardRecord;
import com.bistu.supreme.domain.Response;

@Controller
public class ClassStudentAwardRecordController {
	@Autowired
	private IClassStudentAwardRecordDao casrDao;
	@Autowired
	private IClassMasterDao cmDao;
	@Autowired
	private IStudentDao studentDao;
	
	@RequestMapping(value="/setClassStudentAwardRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setClassStudentAwardRecord(@RequestBody ClassStudentAwardRecord csar) {
		Response response = new Response();
		csar.setCsarClassMasterName(cmDao.getCMNamebyNum(csar.getCsarClassMasterNum()));
		csar.setCsarClassNum(cmDao.getClassNumbyNum(csar.getCsarClassMasterNum()));
		csar.setCsarStudentNum(studentDao.getStudentNumbyName(csar.getCsarStudentName()));
		if(casrDao.createClassStudentAwardRecord(csar)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/deleteClassStudentAwardRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteClassStudentAwardRecord(@RequestBody int id) {
		Response response = new Response();
		if(casrDao.deleteClassStudentAwardRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/updateClassStudentAwardRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateClassStudentAwardRecord(@RequestBody ClassStudentAwardRecord csar) {
		Response response = new Response();
		csar.setCsarStudentNum(studentDao.getStudentNumbyName(csar.getCsarStudentName()));
		if(casrDao.updateClassStudentAwardRecordbyId(csar)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/getClassStudentAwardRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassStudentAwardRecord(@RequestBody String num) {
		Response response = new Response();
		List<ClassStudentAwardRecord> list = casrDao.getClassStudentAwardRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success("no_record_found");
		}
		else
			if(list.get(0).getCsarId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
