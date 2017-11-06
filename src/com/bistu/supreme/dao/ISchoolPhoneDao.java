package com.bistu.supreme.dao;

import java.util.List;
import com.bistu.supreme.domain.SchoolPhone;

/**
 * @author LIZHIWEI
 *
 */
public interface ISchoolPhoneDao {
	/**
	 * 获取所有学院的电话
	 * */
	public List<SchoolPhone> getAllSchoolPhone();
}
