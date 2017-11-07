package com.bistu.supreme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassNoticeDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.ClassNotice;

/**
 * @author LIZHIWEI
 *
 */

@Controller
public class ClassNoticeController {
	@Autowired
	private IClassNoticeDao classNoticeDao;
	@RequestMapping(value="/classNotice",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response update(@RequestBody ClassNotice classNotice){
		Response response = new Response();
		String noteTitle = classNotice.getNoteTitle();
		String noteTeachweNum = classNotice.getNoteTeachweNum();
		String noteContent = classNotice.getNoteContent();
		String noteTargetClass = classNotice.getNoteTargetClass();
		int classNoticeResult = classNoticeDao.addClassNotice(noteTitle, noteTeachweNum, noteContent, noteTargetClass);
		if(classNoticeResult>0){
			return response.success();
		}
		else
			return response.failure();
	}
}
