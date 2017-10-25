package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.*;;
/**
 * 获得学生手册中的所有信息
 * */
public interface IHandbookDao {
	public List<Handbook> getAll();
}
