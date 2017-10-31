package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ICommonProblemDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.CommonProblem;

	@Controller
	public class CommonProblemController {
		@Autowired
		private ICommonProblemDao CommonProblemDao;
		
		
		@RequestMapping(value="/commonProblem",method=RequestMethod.POST,
				produces= {"application/json;charset=UTF-8"})
		@ResponseBody
		public Response CommonProblem(){
			Response response=new Response();
			List<CommonProblem> list=CommonProblemDao.findAll();
			if(list==null )
				return response.failure("information_incorrect");
			else {
				
				return response.success(list);
			}

		}
	}
