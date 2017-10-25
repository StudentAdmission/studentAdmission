package com.bistu.supreme.domain;
/**
 * 邮件实体类的bean
 * */
public class MailModel {
	/**
     * 发件人邮箱服务器
     */
    private String emailHost;
    /**
     * 发件人邮箱
     */
    private String emailFrom;

    /**
     * 发件人用户名
     */
    private String emailUserName;

    /**
     * 发件人密码
     */
    private String emailPassword;

    /**
     * 收件人邮箱，多个邮箱以“;”分隔
     */
    private String toEmails;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 发送人地址1个
     * */
    private String fromAddress;
    /**
     * 接收人地址,可以为很多个，每个地址之间用";"分隔，比方说450065208@qq.com;lpf@sina.com
     * */
    private String toAddresses;
    
    public MailModel() {
    	this.emailHost = "smtp.163.com";
    	this.emailFrom = "18810912096@163.com";
    	this.emailUserName = "18810912096@163.com";
    	this.emailPassword = "ldf2014";
    	this.fromAddress = "18810912096@163.com";
    }
    
	public String getEmailHost() {
		return emailHost;
	}
	
	public String getEmailFrom() {
		return emailFrom;
	}
	
	public String getEmailUserName() {
		return emailUserName;
	}
	
	public String getEmailPassword() {
		return emailPassword;
	}
	
	public String getToEmails() {
		return toEmails;
	}
	public void setToEmails(String toEmails) {
		this.toEmails = toEmails;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	
	public String getToAddresses() {
		return toAddresses;
	}
	public void setToAddresses(String toAddresses) {
		this.toAddresses = toAddresses;
	}
    
}
