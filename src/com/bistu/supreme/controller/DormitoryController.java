package com.bistu.supreme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IDormitoryDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.Student;

@Controller
public class DormitoryController {
	/**
	 * 获取所有室友的信息(宿舍名， 室友名，室友学号，室友电话，室友籍贯 )
	 * */
	@Autowired
	IDormitoryDao dormitoryDao;
	@RequestMapping(value="/getDorm",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getAllDormMessage(@RequestBody String studentId){
		Response response = new Response();
		List<Student> allDormMessageList = dormitoryDao.getAllDormMessage(studentId);
		if(allDormMessageList.size() != 0 && !allDormMessageList.get(0).getStdNum().equals("-1")){
			return response.success(allDormMessageList);
		}
		else if(allDormMessageList.size() == 0){
			return response.success("The student hasn't roommates",allDormMessageList);
		}
		else
			return response.failure();
		
	}
}
