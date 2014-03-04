package com.mobilepark.uxcutor.userContentsMap.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilepark.uxcutor.framework.dao.GenericDao;
import com.mobilepark.uxcutor.framework.service.GenericServiceImpl;
import com.mobilepark.uxcutor.userContentsMap.dao.UserContentsMapDao;
import com.mobilepark.uxcutor.userContentsMap.model.UserContentsMap;

@Service
@Transactional
public class UserContentsMapServiceImpl extends
		GenericServiceImpl<UserContentsMap> implements
		UserContentsMapService {

	@Autowired
	private UserContentsMapDao userContentsMapDao;

	@Override
	protected GenericDao<UserContentsMap> getGenericDao() {
		return userContentsMapDao;
	}

	@Override
	public String getUser_id(HashMap<String, Object> hash) {
		// TODO Auto-generated method stub
		return userContentsMapDao.getUser_id(hash);
	}

}
