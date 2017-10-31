package com.bistu.supreme.dao;
import java.util.List;

import com.bistu.supreme.domain.CommonProblem;
/*常见问题查询接口*/

public interface ICommonProblemDao {
	public List<CommonProblem> findAll();
}
