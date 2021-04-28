package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.User;


public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//戻り値用のUserインスタンスの生成
		User user = new User();
		
		//ResultSetの取得結果をUserインスタンスにせっと
		
		user.setUser_id(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		return user;
	}
	
	

}
