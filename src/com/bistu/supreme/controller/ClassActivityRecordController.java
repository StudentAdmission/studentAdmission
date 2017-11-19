package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassActivityRecordDao;
import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.domain.ClassActivityRecord;
import com.bistu.supreme.domain.Response;

@Controller
public class ClassActivityRecordController {
	@Autowired
	private IClassActivityRecordDao carDao;
	@Autowired
	private IClassMasterDao cmDao;
	
	@RequestMapping(value="/setClassActivityRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setClassActivityRecord(@RequestBody ClassActivityRecord car) {
		Response response = new Response();
		car.setCacrClassMasterName(cmDao.getCMNamebyNum(car.getCacrClassMasterNum()));
		car.setCacrClassNum(cmDao.getClassNumbyNum(car.getCacrClassMasterNum()));
		if(carDao.createClassActivityRecord(car)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/deleteClassActivityRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteClassActivityRecord(@RequestBody int id) {
		Response response = new Response();
		if(carDao.deleteClassActivityRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/updateClassActivityRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateClassWillRecord(@RequestBody ClassActivityRecord car) {
		Response response = new Response();
		if(carDao.updateClassActivityRecordbyId(car)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/getClassActivityRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassActivityRecord(@RequestBody String num) {
		Response response = new Response();
		List<ClassActivityRecord> list = carDao.getClassActivityRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success("no_record_found");
		}
		else
			if(list.get(0).getCacrId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
