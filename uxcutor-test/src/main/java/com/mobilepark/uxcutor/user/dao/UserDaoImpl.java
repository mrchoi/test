package com.mobilepark.uxcutor.user.dao;

import org.springframework.stereotype.Repository;

import com.mobilepark.uxcutor.framework.dao.GenericDaoImpl;
import com.mobilepark.uxcutor.user.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements
		UserDao {

	@Override
	public String setSqlMdel() {
		return "user";
	}

}
