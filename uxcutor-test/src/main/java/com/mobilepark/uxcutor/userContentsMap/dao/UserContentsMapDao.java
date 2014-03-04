package com.mobilepark.uxcutor.userContentsMap.dao;

import java.util.HashMap;

import com.mobilepark.uxcutor.framework.dao.GenericDao;
import com.mobilepark.uxcutor.userContentsMap.model.UserContentsMap;

public interface UserContentsMapDao extends GenericDao<UserContentsMap> {

	public abstract String getUser_id(HashMap<String, Object> hash);

}
