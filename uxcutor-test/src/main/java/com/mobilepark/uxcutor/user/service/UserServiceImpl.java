package com.mobilepark.uxcutor.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilepark.uxcutor.framework.dao.GenericDao;
import com.mobilepark.uxcutor.framework.service.GenericServiceImpl;
import com.mobilepark.uxcutor.user.dao.UserDao;
import com.mobilepark.uxcutor.user.model.User;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements
		UserService {

	@Autowired
	private UserDao userDao;

	@Override
	protected GenericDao<User> getGenericDao() {
		return userDao;
	}

}
