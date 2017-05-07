package com.asiainfo.multidatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.multidatasource.dao.IUserDao;
import com.asiainfo.multidatasource.datasource.DataSource;
import com.asiainfo.multidatasource.model.User;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午5:09:56
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
@Service
@Transactional
@DataSource("slave")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	/* 
	 * @Description: TODO
	 * @param userId
	 * @param userName
	 * @see com.asiainfo.multidatasource.service.IUserService#save(java.lang.String, java.lang.String)
	 */
	@Override
	@DataSource("master")
	public void save(String userId, String userName) {
		this.dao.save(new User(userId, userName));
	}

	/* 
	 * @Description: TODO
	 * @param userId
	 * @return
	 * @see com.asiainfo.multidatasource.service.IUserService#queryUser(java.lang.String)
	 */
	@Override
	public User queryUser(String userId) {
		return this.dao.queryByUserId(userId);
	}
}
