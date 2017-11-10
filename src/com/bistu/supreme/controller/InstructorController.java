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

import com.bistu.supreme.dao.IInstructorDao;
import com.bistu.supreme.domain.Response;

/**
 * @author LIZHIWEI
 *辅导员控制器
 */
@Controller
public class InstructorController {
	@Autowired
	private IInstructorDao instructorDao;
	
	@RequestMapping(value="/getAllClass",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getClassmates(@RequestBody String num) {
		Response response = new Response();
		List<Object> allList = instructorDao.getAllClassStudentAndClassMasterInfo();
		if(allList!=null){
			if (allList.get(0) instanceof Integer) {
				return response.failure("connect SQL fail");
			} 
			else{
				return response.success(allList);
			}
		}
		else
			return response.failure("connect SQL fail");
		
	}
}
