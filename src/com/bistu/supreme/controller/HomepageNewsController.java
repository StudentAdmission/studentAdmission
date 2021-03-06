package com.bistu.supreme.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bistu.supreme.dao.IHomepageNewsDao;
import com.bistu.supreme.domain.HomepageNews;
import com.bistu.supreme.domain.Response;

/**
 * 首页新闻信息控制器
 * @author LIZHIWEI
 *
 */
@Controller
public class HomepageNewsController {
	@Autowired
	private IHomepageNewsDao homepageNewsDao;
	@RequestMapping(value="/homepageNews",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getHomepageNewsInfo(){
		Response response = new Response();
		List<HomepageNews> homepageNewsList = homepageNewsDao.getAll();
		if(homepageNewsList!=null){
			if(homepageNewsList.get(0).getHomepageNewsId()!=-1){
				return response.success(homepageNewsList);
			}
			else
				return response.failure("SQL connect fail");
		}
		else
			return response.success("数据库中没有通知");
			
	}
	
}
