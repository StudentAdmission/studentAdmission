package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IHomepageReportingProcessDao;
import com.bistu.supreme.domain.HomepageReportingProcess;
import com.bistu.supreme.domain.Response;
/**
 * 首页报到流程信息控制器
 * @author LIZHIWEI
 *
 */
@Controller
public class HomepageReportingProcessController {
	@Autowired
	private IHomepageReportingProcessDao homepageReportingProcessDao;
	@RequestMapping(value="/homepageReportingProcess",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getHomepageReportingProcessInfo(){
		Response response = new Response();
		List<HomepageReportingProcess> homepageReportingProcessList = homepageReportingProcessDao.getAll();
		if(homepageReportingProcessList!=null){
			return response.success(homepageReportingProcessList);
		}
		else
			return response.failure("no_such_info");
	}
}
