package com.bistu.supreme.dao;

import java.util.List;

import com.bistu.supreme.domain.HomepageReportingProcess;

/**
 * @author LIZHIWEI
 *获取报到流程信息的接口
 */
public interface IHomepageReportingProcessDao {
	public List<HomepageReportingProcess> getAll();
}
