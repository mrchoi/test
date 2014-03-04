package com.mobilepark.uxcutor.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericService<M extends Serializable> {
	
	List<M> list(Map<String, Object> paramMap);

	int count(Map<String, Object> paramMap);
	
	int insert(M model);
	
	int update(M model);
	
	int updateHit(Map<String, Object> paramMap);
	
	int delete(M model);
	
	M view(M model);
}
