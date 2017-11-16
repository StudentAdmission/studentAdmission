package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_school_associations表
 * */
public class SchoolAssociations {
	/**
	 * 社团Id
	 * */
	private int associationsId;
	/**
	 * 社团图片
	 * */
	private String associationsGraph;
	/**
	 * 社团名称
	 * */
	private String associationsName;
	/**
	 * 社团简介
	 * */
	private String associationsIntroduction;
	/**
	 * 优先级
	 * */
	private int associationsPriority;
	
	public int getAssociationsId() {
		return associationsId;
	}
	public void setAssociationsId(int associationsId) {
		this.associationsId = associationsId;
	}
	public String getAssociationsGraph() {
		return associationsGraph;
	}
	public void setAssociationsGraph(String associationsGraph) {
		this.associationsGraph = associationsGraph;
	}
	public String getAssociationsName() {
		return associationsName;
	}
	public void setAssociationsName(String associationsName) {
		this.associationsName = associationsName;
	}
	public String getAssociationsIntroduction() {
		return associationsIntroduction;
	}
	public void setAssociationsIntroduction(String associationsIntroduction) {
		this.associationsIntroduction = associationsIntroduction;
	}
	public int getAssociationsPriority() {
		return associationsPriority;
	}
	public void setAssociationsPriority(int associationsPriority) {
		this.associationsPriority = associationsPriority;
	}
}
