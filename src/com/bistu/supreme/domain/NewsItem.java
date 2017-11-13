/**
 * 
 */
package com.bistu.supreme.domain;

/**
 * @author LIZHIWEI
 *对应的是sa_news_item
 */
public class NewsItem {
	/**
	 * 新闻的ID
	 * */
	private int itemId;
	/**
	 * 新闻的标题
	 * */
	private String itemTitle;
	/**
	 * 新闻的事件
	 * */
	private String itemTime;
	/**
	 * 新闻的内容
	 * */
	private String itemContent;
	/**
	 * 新闻的优先级
	 * */
	private int itemPriority;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemTime() {
		return itemTime;
	}
	public void setItemTime(String itemTime) {
		this.itemTime = itemTime;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getItemPriority() {
		return itemPriority;
	}
	public void setItemPriority(int itemPriority) {
		this.itemPriority = itemPriority;
	}
	
	public static void main(String[] ars){
		NewsItem news = new NewsItem();
		news.setItemTime("2017-11-13 15:43:26.0");
		System.out.println(news.getItemTime());
		System.out.println(news.getItemTime());
	}
}
