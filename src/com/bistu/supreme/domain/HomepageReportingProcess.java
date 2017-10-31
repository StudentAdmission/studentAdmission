package com.bistu.supreme.domain;

import java.sql.Date;

public class HomepageReportingProcess {
	private int processId;
	private String processItem;
	private Date processTime;
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
	public Date getProcessTime() {
		return processTime;
	}
	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}
	public String getProcessLink() {
		return processLink;
	}
	public void setProcessLink(String processLink) {
		this.processLink = processLink;
	}
}
