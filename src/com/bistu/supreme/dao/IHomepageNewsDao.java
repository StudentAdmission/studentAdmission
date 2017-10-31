package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.HomepageNews;

/**
 * 获取首页新闻所有信息的接口
 *
 */
public interface IHomepageNewsDao {
	public List<HomepageNews> getAll();
}
