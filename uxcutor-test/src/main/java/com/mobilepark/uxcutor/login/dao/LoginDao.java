package com.mobilepark.uxcutor.login.dao;


import com.mobilepark.uxcutor.user.model.User;

public interface LoginDao {

	public abstract User loginCheck(User user);
}