package com.bistu.supreme.domain;

public class VerificationCode {
	/**
	 * 验证码的内容
	 * */
	private String code;

	public VerificationCode() {
		this.code = randomCode();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 产生随机的六位验证码
	 * 单个字符0~9表示数字，10~35表示字母
	 * */
	private String randomCode() {
		String str = "";
		int a = 0;
		for(int i = 0;i < 6;i++) {
			a = (int)Math.floor(Math.random()*36);
			if(a<10) {
				str += a;
			}
			else {
				str += (char)('a' + a -10);
			}
		}
		return str;
	}
	public static void main(String[] args) {
		VerificationCode vc = new VerificationCode();
		System.out.println(vc.getCode());
	}
}
