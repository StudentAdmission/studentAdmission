package com.bistu.supreme.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bistu.supreme.dao.IRollingGraphDao;
import com.bistu.supreme.domain.RollingGraph;
import com.bistu.supreme.domain.Login;
import com.bistu.supreme.domain.Response;


@Controller
public class RollingGraphController {
	@Autowired
	private IRollingGraphDao RollingGraphDao;
	
	
	@RequestMapping(value="/rollingGraph",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response rollingGraph(@RequestBody RollingGraph rollingGraph){
		Response response=new Response();
		RollingGraph graph_new=null;
		
		List<RollingGraph> list=RollingGraphDao.findAll();
		if(list==null )
			return response.failure("information_incorrect");
		else {
			
			return response.success(list);
		

	}
	}

}
