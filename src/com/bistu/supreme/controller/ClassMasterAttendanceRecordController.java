package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassMasterAttendanceRecordDao;
import com.bistu.supreme.dao.IClassMasterDao;
import com.bistu.supreme.domain.ClassMasterAttendanceRecord;
import com.bistu.supreme.domain.Response;

@Controller
public class ClassMasterAttendanceRecordController {
	@Autowired
	private IClassMasterAttendanceRecordDao carDao;
	@Autowired
	private IClassMasterDao cmDao;
	
	@RequestMapping(value="/setClassMasterAttendanceRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response setClassMasterAttendanceRecord(@RequestBody ClassMasterAttendanceRecord car) {
		Response response = new Response();
		car.setCarClassMasterName(cmDao.getCMNamebyNum(car.getCarClassMasterNum()));
		if(carDao.createClassMasterAttendanceRecord(car)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/deleteClassMasterAttendanceRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response deleteClassMasterAttendanceRecord(@RequestBody int id) {
		Response response = new Response();
		if(carDao.deleteClassMasterAttendanceRecordbyId(id)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/updateClassMasterAttendanceRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateClassMasterAttendanceRecord(@RequestBody ClassMasterAttendanceRecord car) {
		Response response = new Response();
		if(carDao.updateClassMasterAttendanceRecordbyId(car)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
	
	@RequestMapping(value="/getClassMasterAttendanceRecord",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassMasterAttendanceRecord(@RequestBody String num) {
		Response response = new Response();
		List<ClassMasterAttendanceRecord> list = carDao.getClassMasterAttendanceRecordbyClassmasterNum(num);
		if(list == null||list.size() == 0) {
			return response.success("no_record_found");
		}
		else
			if(list.get(0).getCarId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
