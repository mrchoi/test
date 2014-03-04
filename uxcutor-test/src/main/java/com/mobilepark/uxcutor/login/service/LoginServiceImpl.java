package com.mobilepark.uxcutor.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilepark.uxcutor.login.dao.LoginDao;
import com.mobilepark.uxcutor.user.model.User;


@Service
@Transactional
public class LoginServiceImpl implements LoginService
{

	@Autowired
	private LoginDao dao;
	
	public User loginCheck(User user) {
		return dao.loginCheck(user);
	}
	
}