package com.bistu.supreme.domain;

/**
 * @author LIZHIWEI
 *学校电话类
 */
public class SchoolPhone {
	/**
	 * 学院电话的id
	 */
	private int spID;
	
	/**
	 * 学院的名字
	 * */
	
	private String spCollegeName;
	
	/**
	 * 学院的电话
	 * */
	
	private int spCollegePhone;

	public int getSpID() {
		return spID;
	}

	public void setSpID(int spID) {
		this.spID = spID;
	}

	public String getSpCollegeName() {
		return spCollegeName;
	}

	public void setSpCollegeName(String spCollegeName) {
		this.spCollegeName = spCollegeName;
	}

	public int getSpCollegePhone() {
		return spCollegePhone;
	}

	public void setSpCollegePhone(int spCollegePhone) {
		this.spCollegePhone = spCollegePhone;
	}
	
	
}
