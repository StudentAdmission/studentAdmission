package com.bistu.supreme.controller;

import java.util.HashMap;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ILoginDao;
import com.bistu.supreme.dao.IMailDao;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.domain.VerificationCode;

/**
 * 邮件发送控制器
 * */
@Controller
public class MailController {
	@Autowired
	private IMailDao mailDao;
	@Autowired
	private ILoginDao loginDao;
//	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/mail",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response sendMail(@RequestBody String address) {
//		logger.info("执行到sendMail方法，toAddress的值为：" + toAddress.get("address"));
		Response response = new Response();
		VerificationCode vc = new VerificationCode();
		if(mailDao.sendEMail(address, vc.getCode()))
			return response.success(vc);
		else
			return response.failure("address_not_found");
	}
	
	@RequestMapping(value="/forgetPwd",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response forgetPwd(@RequestBody String num) {
//		logger.info("执行到sendMail方法，toAddress的值为：" + toAddress.get("address"));
		System.out.println("学号为：" + num);
		Response response = new Response();
		String address = loginDao.getEmailbyNum(num);
		if(address.equals("empty")) {
			return response.failure("user_not_found");
		}
		else
			if(address.equals("exception")) {
				return response.failure("sql_connect_fail");
			}
			else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("login_email",address);
				return response.success(map);
			}
	}
}
