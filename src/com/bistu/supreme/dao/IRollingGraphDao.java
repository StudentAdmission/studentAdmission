package com.bistu.supreme.dao;
import java.util.List;
import com.bistu.supreme.domain.RollingGraph;
/**
 * 轮播图接口
 */
public interface IRollingGraphDao {
	public List<RollingGraph> findAll();
}
