/**
 * 
 */
package com.bistu.supreme.domain;

/**
 * @author LIZHIWEI
 *对应sa_school_profile表
 */
public class SchoolProfile {
	/**
	 * 简介ID
	 * */
	private int profileId;
	/**
	 * 简介文本内容
	 * */
	private String profileContent;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfileContent() {
		return profileContent;
	}
	public void setProfileContent(String profileContent) {
		this.profileContent = profileContent;
	}
	
}
