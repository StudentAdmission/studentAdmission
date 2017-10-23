package com.bistu.supreme.dao;

import java.util.Map;

/**
 * 登录判定接口
 * */
public interface ILoginDao {
	/**
	 * 根据用户名密码判断是否可以登录
	 * */
	public Map<String, Integer> findLogin(String login_num, String login_pwd);
}
