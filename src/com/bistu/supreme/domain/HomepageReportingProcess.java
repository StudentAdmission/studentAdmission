package com.bistu.supreme.domain;

import java.sql.Date;

/**
 * @author LIZHIWEI
 *首页报到流程的基本类
 */
public class HomepageReportingProcess {
	/*首页报到流程的ID*/
	private int processId;
	/*首页报到流程的标题*/
	private String processItem;
	/*首页报到流程的时间*/
	private String processTime;
	/*首页报到流程的链接*/
	private String processLink;
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getProcessItem() {
		return processItem;
	}
	public void setProcessItem(String processItem) {
		this.processItem = processItem;
	}
	public String getProcessTime() {
		return processTime;
	}
	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}
	public String getProcessLink() {
		return processLink;
	}
	public void setProcessLink(String processLink) {
		this.processLink = processLink;
	}
	
}
