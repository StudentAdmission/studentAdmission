package com.bistu.supreme.controller;

import java.util.Map;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
//	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/mail",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response sendMail(@RequestBody Map<String,String> toAddress) {
//		logger.info("执行到sendMail方法，toAddress的值为：" + toAddress.get("address"));
		Response response = new Response();
		VerificationCode vc = new VerificationCode();
		String address = toAddress.get("address");
		if(mailDao.sendEMail(address, vc.getCode()))
			return response.success(vc);
		else
			return response.failure("address not found");
	}
}
