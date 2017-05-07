package com.asiainfo.multidatasource.dao;

import com.asiainfo.multidatasource.model.User;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午5:00:26
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public interface IUserDao {

	public void save(User user);
	
	public User queryByUserId(String userId);
}
