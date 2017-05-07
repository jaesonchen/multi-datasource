package com.asiainfo.multidatasource.service;

import com.asiainfo.multidatasource.model.User;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午5:09:03
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public interface IUserService {

	public void save(String userId, String userName);
	
	public User queryUser(String userId);
}
