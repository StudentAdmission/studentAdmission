package com.bistu.supreme.dao;


import com.bistu.supreme.domain.Login;


/**
 * 登录判定接口
 * */
public interface ILoginDao {
	/**
	 * 根据用户名密码判断是否可以登录
	 * */
	public String findLogin(String login_num, String login_pwd);
	/**
	 * 通过学号获取登录表中的信息
	 * */
	public Login getLoginbyNum(String num);
	/**
	 * 从数据库获取登录20分钟后的时间
	 * */
	public String getLoginTime(String num);
	/**
	 * 更新登录时间
	 * */
	public boolean updateLoginTime(String num, String time);
	/**
	 * 根据学号（或工号）获取邮箱
	 * */
	public String getEmailbyNum(String num);
	
	/**
	 * 根据ID，邮箱，密码，头像来修改密码
	 * */
	public boolean revisePwd(String loginNum,String loginEmail,String pwd,String loginPortrait,String loginNickName);
	/**
	 * 忘记密码的修改密码
	 * */
	public boolean forgetPwdRevise(Login login);
}
