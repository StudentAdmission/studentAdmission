package com.bistu.supreme.controller;

import java.util.HashMap;
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
		String login_num = login.getLoginNum();
		String login_pwd = login.getLoginPwd();
		Map<String, Object> map = loginDao.findLogin(login_num, login_pwd);
		if((int)map.get("login_id") == -1)
			return response.failure("information_incorrect");
		else {
			Map<String,Object> login_new = new HashMap<String,Object>();
			login_new.put("loginNum", login_num);
			login_new.put("loginPortrait", map.get("login_portrait"));
			login_new.put("loginNickname", map.get("login_nickname"));
			login_new.put("loginTag", map.get("login_tag"));
			return response.success(login_new);
		}
	}
	
	@RequestMapping(value="/login/gettime",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getTime(@RequestBody Login login) {
		Response response = new Response();
		Map<String, String> map = new HashMap<String, String>();
		String num = login.getLoginNum();
		String time = loginDao.getLoginTime(num);
		if(time.equals("-1")){
			return response.failure("db_connect_exception");	
		}
		else {
			map.put("loginTime", time);
			return response.success(map);
		}
	}
	
	@RequestMapping(value="/login/time",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response updateTime(@RequestBody Login login) {
		Response response = new Response();
		String num = login.getLoginNum();
		String time = login.getLoginTime();
		if(!loginDao.updateLoginTime(num, time)){
			return response.failure("db_connect_exception");	
		}
		else {
			return response.success();
		}
	}
	
	/**
	 * 修改密码的控制器
	 * */
	@RequestMapping(value="/revisePwd",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public int revisePwd(@RequestBody String loginNum, String loginEmail, String loginNickName, String pwd, String loginPortrait){
		if(loginDao.revisePwd(loginNum, loginEmail, pwd, loginPortrait, loginNickName)){
			return 1;
		}
		else
			return 0;
	}
	
	@RequestMapping(value="/forget/pwd",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response forgetPwdRevise(@RequestBody Login login) {
		Response response = new Response();
		if(loginDao.forgetPwdRevise(login)) {
			return response.success();
		}
		else {
			return response.failure("sql_exception");
		}
	}
}
