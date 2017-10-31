package com.bistu.supreme.domain;

import java.sql.Date;

/**
 * @author LIZHIWEI
 *
 */
public class HomepageNews {
	private int homepageNewsId;
	private String homepageNewTitle;
	private Date homepageNewsTime;
	private String homepageNewsLink;
	public int getHomepageNewsId() {
		return homepageNewsId;
	}
	public void setHomepageNewsId(int homepageNewsId) {
		this.homepageNewsId = homepageNewsId;
	}
	public String getHomepageNewTitle() {
		return homepageNewTitle;
	}
	public void setHomepageNewTitle(String homepageNewTitle) {
		this.homepageNewTitle = homepageNewTitle;
	}
	public Date getHomepageNewsTime() {
		return homepageNewsTime;
	}
	public void setHomepageNewsTime(Date homepageNewsTime) {
		this.homepageNewsTime = homepageNewsTime;
	}
	public String getHomepageNewsLink() {
		return homepageNewsLink;
	}
	public void setHomepageNewsLink(String homepageNewsLink) {
		this.homepageNewsLink = homepageNewsLink;
	}
	
	
}
