package com.bistu.supreme.dao.impl;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Repository;

import com.bistu.supreme.dao.IMailDao;

/**
 * 邮件发送接口的实现类
 * */
@Repository
public class AliyunMailDaoImpl implements IMailDao{

	private static final String ALIDM_SMTP_HOST = "smtp.mxhichina.com";
    private static final int ALIDM_SMTP_PORT = 25;//或80
	
	@Override
	public boolean sendEMail(String toAddress, String vCode) {
		// TODO Auto-generated method stub
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // 发件人的账号
        props.put("mail.user", "postmaster@bistusupreme.top");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "Supreme123456");
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
//        mailSession.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {
        // 设置发件人
        InternetAddress from = new InternetAddress("postmaster@bistusupreme.top");
        message.setFrom(from);
        Address[] a = new Address[1];
        a[0] = new InternetAddress("postmaster@bistusupreme.top");
        message.setReplyTo(a);
        // 设置收件人
        InternetAddress to = new InternetAddress(toAddress);
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        // 设置邮件标题
        message.setSubject("BISTU-学生管理系统-密码找回");
        // 设置邮件的内容体
        message.setContent("您的验证码为：" + vCode + "，有效期为10分钟，请尽快完成验证。", "text/html;charset=UTF-8");
        // 发送邮件
        Transport.send(message);
        return true;
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
            System.out.println(err);
            return false;
        }
	}
	
}
