package com.asiainfo.multidatasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.asiainfo.multidatasource.model.User;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午5:01:16
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* 
	 * @Description: TODO
	 * @param userId
	 * @return
	 * @see com.asiainfo.multidatasource.dao.IUserDao#queryByUserId(java.lang.String)
	 */
	@Override
	public User queryByUserId(String userId) {

		StringBuilder sql = new StringBuilder("select user_id, user_name from mcd_user where user_id=?");
		List<User> list = this.jdbcTemplate.query(sql.toString(), new Object[] {userId}, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				return user;
			}
		});
		return (null == list || list.isEmpty()) ? null : list.get(0);
	}

	/* 
	 * @Description: TODO
	 * @param user
	 * @see com.asiainfo.multidatasource.dao.IUserDao#save(com.asiainfo.multidatasource.model.User)
	 */
	@Override
	public void save(User user) {

		StringBuilder sql = new StringBuilder("insert into mcd_user(user_id, user_name) values(?, ?)");
		this.jdbcTemplate.update(sql.toString(), new Object[] { user.getUserId(), user.getUserName() });
	}
}
