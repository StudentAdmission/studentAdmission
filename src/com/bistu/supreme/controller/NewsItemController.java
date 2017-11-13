/**
 * 
 */
package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.domain.NewsItem;
import com.bistu.supreme.dao.INewsItemDao;
import com.bistu.supreme.domain.Response;

/**
 * @author LIZHIWEI
 *
 */
@Controller
public class NewsItemController {
	@Autowired
	private INewsItemDao newsItemDao;
	
	@RequestMapping(value="/news/item",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getNewsItem(){
		Response response = new Response();
		List<NewsItem> newsItemList = newsItemDao.getAllNewsItem();
		if(newsItemList!=null){
			if(newsItemList.get(0).getItemId()!=-1){
				return response.success(newsItemList);
			}
			else
				return response.failure("连接数据库出错");
		}
		else
			return response.success();
	}
}
