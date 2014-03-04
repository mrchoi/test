package com.mobilepark.uxcutor.userContentsMap.service;

import java.util.HashMap;

import com.mobilepark.uxcutor.framework.service.GenericService;
import com.mobilepark.uxcutor.userContentsMap.model.UserContentsMap;

public interface UserContentsMapService extends GenericService<UserContentsMap> {

	public abstract String getUser_id(HashMap<String, Object> hash);

}
