package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.User;

@Repository("UserDaoJdbcImpl2")

public class UserDaojdbcImpl2 extends UserDaojdbcImpl{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public User selectOne(String  user_id) {
		
		//1件取得
		String sql = "SELECT FROM * user_info WHERE user_id =?";
		
		//RowMapperの生成
		UserRowMapper rowMapper = new UserRowMapper();
		
		
		return jdbc.queryForObject(sql, rowMapper,user_id);
		
		
	}
}
