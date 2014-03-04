package com.mobilepark.uxcutor.contents.dao;

import org.springframework.stereotype.Repository;

import com.mobilepark.uxcutor.contents.model.Contents;
import com.mobilepark.uxcutor.framework.dao.GenericDaoImpl;

@Repository
public class ContentsDaoImpl extends GenericDaoImpl<Contents> implements
		ContentsDao {

	@Override
	public String setSqlMdel() {
		return "contents";
	}

}
