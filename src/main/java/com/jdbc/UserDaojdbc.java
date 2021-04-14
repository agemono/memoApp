package com.jdbc;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.user.User;

public interface UserDaojdbc {
	public int count() throws DataAccessException;
	
	public int insertOne(User user)throws DataAccessException;
	
	public User selectOne(String userId)throws DataAccessException;
	
	public List<User> selectMany()throws DataAccessException;
	
	public int updateOne(User user)throws DataAccessException;
	
	public int deleteOne(String userId)throws DataAccessException;

	
}
