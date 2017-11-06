/**
 * 实现获取学院电话功能的控制器
 */
package com.bistu.supreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ISchoolPhoneDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.SchoolPhone;

/**
 * @author LIZHIWEI
 *
 */
@Controller
public class SchoolPhoneController {
	@Autowired
	private ISchoolPhoneDao schoolPhoneDao;
	@RequestMapping(value="/schoolPhone",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getSchoolPhoneInfo(){
		Response response = new Response();
		List<SchoolPhone> schoolPhoneList = schoolPhoneDao.getAllSchoolPhone();
		
		if(schoolPhoneList!=null&&schoolPhoneList.get(0).getSpID()!=-1){
			return response.success(schoolPhoneList);
		}
		else
			return response.failure("SQL connect fail");
	}

}
