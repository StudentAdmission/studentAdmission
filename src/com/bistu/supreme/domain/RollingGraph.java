package com.bistu.supreme.domain;

/**
 * 
 * @author BXY 对应数据库中的rolling_graph表
 *
 */
public class RollingGraph {
	/**
	 * 轮播图的id
	 *
	 */
	private int graph_id;
	/**
	 * 轮播图的名字
	 *
	 */
	private String graph_name;
	/**
	 * 
	 * 轮播图的优先级
	 * 
	 */
	private int graph_prioity;
    /**
    * get/set函数
    * 
    */
	
	public int getGraph_id() {
		return graph_id;
	}
	public RollingGraph() {
		super();
	}
	public RollingGraph(int graph_id) {
		super();
		this.graph_id = graph_id;
	}
	public void setGraph_id(int graph_id) {
		this.graph_id = graph_id;
	}
	public String getGraph_name() {
		return graph_name;
	}
	public void setGraph_name(String graph_name) {
		this.graph_name = graph_name;
	}
	public int getGraph_prioity() {
		return graph_prioity;
	}
	public void setGraph_prioity(int graph_prioity) {
		this.graph_prioity = graph_prioity;
	}


}
