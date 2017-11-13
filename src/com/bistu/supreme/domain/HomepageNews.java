package com.bistu.supreme.domain;


/**
 * @author LIZHIWEI
 *
 */
/*首页新闻的基本类*/
public class HomepageNews {
	/*首页新闻的ID*/
	private int homepageNewsId;
	/*首页新闻的标题*/
	private String homepageNewsTitle;
	/*首页新闻的时间*/
	private String homepageNewsTime;
	/*首页新闻的链接*/
	private String homepageNewsLink;
	public int getHomepageNewsId() {
		return homepageNewsId;
	}
	public void setHomepageNewsId(int homepageNewsId) {
		this.homepageNewsId = homepageNewsId;
	}
	public String getHomepageNewsTitle() {
		return homepageNewsTitle;
	}
	public void setHomepageNewsTitle(String homepageNewsTitle) {
		this.homepageNewsTitle = homepageNewsTitle;
	}
	public String getHomepageNewsTime() {
		return homepageNewsTime;
	}
	public void setHomepageNewsTime(String homepageNewsTime) {
		this.homepageNewsTime = homepageNewsTime;
	}
	public String getHomepageNewsLink() {
		return homepageNewsLink;
	}
	public void setHomepageNewsLink(String homepageNewsLink) {
		this.homepageNewsLink = homepageNewsLink;
	}
	
}
