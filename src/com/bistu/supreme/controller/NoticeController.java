/**
 * 
 */
package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.domain.Notice;
import com.bistu.supreme.domain.Response;

@Controller
public class NoticeController {
	@Autowired
	private INoticeDao noticeDao;
	@RequestMapping(value="/getAllNotice",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getAllNotice(@RequestBody String studentId){
		Response response = new Response();
		List<Notice> getAllNotice = noticeDao.getAllNoticeOfStudent(studentId);
		if(getAllNotice.get(0).getNoticeId()!=-1&&getAllNotice!=null){
			return response.success(getAllNotice);
		}
		else if(getAllNotice.get(0).getNoticeId()==-1){
			return response.success("the student hasn't messages",getAllNotice);
		}
		else
			return response.failure();
		
	}
}
