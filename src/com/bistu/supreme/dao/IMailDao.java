package com.bistu.supreme.dao;
/**
 * 邮件发送接口
 * */
public interface IMailDao {
	public boolean sendEMail(String to, String vCode);
}
