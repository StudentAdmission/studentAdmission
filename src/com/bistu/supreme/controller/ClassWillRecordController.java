package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.dao.IClassWillRecordDao;
import com.bistu.supreme.domain.ClassWillRecord;
import com.bistu.supreme.domain.Response;

@Controller
public class ClassWillRecordController {
	@Autowired
	private IClassWillRecordDao cwrDao;
	@Autowired
	private IClassMasterDao cmDao;
	
	@RequestMapping(value="/setClassWillRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setClassWillRecord(@RequestBody ClassWillRecord cwr) {
		Response response = new Response();
		cwr.setCwrClassMasterName(cmDao.getCMNamebyNum(cwr.getCwrClassMasterNum()));
		cwr.setCwrClassNum(cmDao.getClassNumbyNum(cwr.getCwrClassMasterNum()));
		if(cwrDao.createClassWillRecord(cwr)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/deleteClassWillRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteClassWillRecord(@RequestBody int id) {
		Response response = new Response();
		if(cwrDao.deleteClassWillRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/updateClassWillRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateClassWillRecord(@RequestBody ClassWillRecord cwr) {
		Response response = new Response();
		if(cwrDao.updateClassWillRecordbyId(cwr)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/getClassWillRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassWillRecord(@RequestBody String num) {
		Response response = new Response();
		List<ClassWillRecord> list = cwrDao.getClassWillRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success("no_record_found");
		}
		else
			if(list.get(0).getCwrId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
