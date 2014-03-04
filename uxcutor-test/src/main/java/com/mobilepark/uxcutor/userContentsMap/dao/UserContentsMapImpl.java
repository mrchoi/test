package com.mobilepark.uxcutor.userContentsMap.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.mobilepark.uxcutor.framework.dao.GenericDaoImpl;
import com.mobilepark.uxcutor.userContentsMap.model.UserContentsMap;

@Repository
public class UserContentsMapImpl extends GenericDaoImpl<UserContentsMap>
		implements UserContentsMapDao {

	@Override
	public String setSqlMdel() {
		return "userContentsMap";
	}

	@Override
	public String getUser_id(HashMap<String, Object> hash) {
		return super.getSqlSession().selectOne("userContentsMap.getUser_id",
				hash);
	}

}
