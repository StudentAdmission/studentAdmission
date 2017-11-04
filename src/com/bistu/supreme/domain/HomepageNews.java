package com.bistu.supreme.domain;

import java.sql.Date;

/**
 * @author LIZHIWEI
 *
 */
/*首页新闻的基本类*/
public class HomepageNews {
	/*首页新闻的ID*/
	private int homepageNewsId;
	/*首页新闻的标题*/
	private String homepageNewTitle;
	/*首页新闻的时间*/
	private Date homepageNewsTime;
	/*首页新闻的链接*/
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
