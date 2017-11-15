/**
 * 
 */
package com.bistu.supreme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ISchoolProfileDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.SchoolProfile;

/**
 * @author LIZHIWEI 2017/11/15 学校简介的控制器
 */
@Controller
public class SchoolProfileController {
	@Autowired
	ISchoolProfileDao SchoolProfileDao;

	@RequestMapping(value = "/getSchoolProfile", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public Response getSchoolProfile() {
		Response response = new Response();
		SchoolProfile schoolProfile = SchoolProfileDao.getSchoolProfile();
		if(schoolProfile==null)
			return response.success();
		else if(schoolProfile.getProfileId()!=-1) {
			return response.success(schoolProfile);
		}
		else
			return response.failure();
	}
}
