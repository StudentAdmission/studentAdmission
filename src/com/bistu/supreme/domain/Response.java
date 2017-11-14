package com.bistu.supreme.domain;

import java.io.Serializable;


/**
 * HttpResponse的类模型
 * */
public class Response implements Serializable{
	
	/**
	 * default id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态码，成功返回1，失败返回0
	 * */
	private int status;
	private String message;
	private Object data;
	
	public Response() {
		this.message = "";
		this.data = null;
	}
	
	public Response success() {
		this.status = 1;
		return this;
	}
	
	public Response success(String message) {
		this.status = 1;
		this.message = message.toString();
		return this;
	}
	
	public Response success(Object data) {
		this.status = 1;
		this.data = data;
		return this;
	}
	
	public Response success(String message, Object data) {
		this.status = 1;
		this.data = data;
		this.message = message;
		return this;
	}
	
	public Response failure() {
		this.status = 0;
		return this;
	}
	
	public Response failure(String message) {
		this.status = 0;
		this.message = message;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
	
}