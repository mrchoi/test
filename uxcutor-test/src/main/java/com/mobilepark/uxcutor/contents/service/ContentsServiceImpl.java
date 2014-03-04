package com.mobilepark.uxcutor.contents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilepark.uxcutor.contents.dao.ContentsDao;
import com.mobilepark.uxcutor.contents.model.Contents;
import com.mobilepark.uxcutor.framework.dao.GenericDao;
import com.mobilepark.uxcutor.framework.service.GenericServiceImpl;

@Service
@Transactional
public class ContentsServiceImpl extends GenericServiceImpl<Contents> implements
		ContentsService {

	@Autowired
	private ContentsDao contentsDao;

	@Override
	protected GenericDao<Contents> getGenericDao() {
		return contentsDao;
	}

}
