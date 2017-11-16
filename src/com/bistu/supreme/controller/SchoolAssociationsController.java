package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ISchoolAssociationsDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.SchoolAssociations;
/**
 * 学校社团信息管理控制器
 * */
@Controller
public class SchoolAssociationsController {
	@Autowired
	private ISchoolAssociationsDao sAsDao;
	
	@RequestMapping(value="/getAssociationsInfo",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getAllAssociationsInfo() {
		Response response = new Response();
		List<SchoolAssociations> list = sAsDao.getAllInfo();
		if(list == null||list.size() == 0) {
			return response.success("no_informations_found");
		}
		else
			if(list.get(0).getAssociationsId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				return response.success(list);
			}
	}
}
