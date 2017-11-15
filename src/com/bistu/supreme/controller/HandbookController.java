package com.bistu.supreme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IHandbookDao;
import com.bistu.supreme.domain.Handbook;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.util.ConvertMethod;
import com.bistu.supreme.util.Write2JSON;
/**
 * 学生手册信息控制器
 * */
@Controller
public class HandbookController {
	@Autowired
	private IHandbookDao handbookDao;
	
	@RequestMapping(value="/handbook",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getHandbookInfo(HttpServletRequest request) {
		Response response = new Response();
		List<Handbook> list = handbookDao.getAll();
		String str = "";
		if(list != null) {
			str = ConvertMethod.ConvertHandBookList2JSON(list);
			Write2JSON.write2Json(request, str, "manualData.json");
			return response.success();
		}
		else {
			return response.failure("no_such_info");
		}
	}
}
