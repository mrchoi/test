package com.mobilepark.uxcutor.login.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.mobilepark.uxcutor.user.model.User;

@Repository
public class LoginDaoImpl extends SqlSessionDaoSupport implements LoginDao {

	public User loginCheck(User user) {
		return super.getSqlSession().selectOne("login.check", user);
	}
}
