package com.bistu.supreme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.ILoginDao;
import com.bistu.supreme.domain.Login;
import com.bistu.supreme.domain.Response;
/**
 * 登录控制器
 * */
@Controller
public class LoginController {
	@Autowired
	private ILoginDao loginDao;
	
	@RequestMapping(value="/login",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response login(@RequestBody Login login) {
		Response response = new Response();
		Login login_new = null;
		String login_num = login.getLoginNum();
		String login_pwd = login.getLoginPwd();
		Map<String, Integer> map = loginDao.findLogin(login_num, login_pwd);
		if(map.get("login_id") == -1)
			return response.failure("information_incorrect");
		else {
			login_new = new Login();
			login_new.setLoginId(map.get("login_id"));
			login_new.setLoginTag(map.get("login_tag"));
			return response.success(login_new);
		}
	}
}
