package com.asiainfo.multidatasource.model;

import java.io.Serializable;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午4:59:17
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userName;
	
	public User() {}
	public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
}
