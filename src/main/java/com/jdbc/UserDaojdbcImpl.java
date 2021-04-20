package com.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.user.User;

@Repository("UserDaojdbcImpl")

public class UserDaojdbcImpl implements UserDaojdbc {

	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public int count() throws DataAccessException {
		int count = jdbc.queryForObject("SELECT COUNT(*)"
				+ "FROM user_info", Integer.class);
		
		return count;
	}

	@Override
	public int insertOne(User user) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		
		String password = passwordEncoder.encode(user.getPassword());
		
		int rowNumber = jdbc.update("INSERT INTO user_info("
				+ "user_id"
				+ "user_pssword)"
				+ "VALUES(?,?)"
				,user.getUserid()
				,password);
		return rowNumber;
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		
		//一件取得
		
		Map<String, Object> map = jdbc.queryForMap(
				"SELECT * FROM user_info"
				+ "WHERE user_id = ?",userId);
		
		//結果返却用の変数
		
		User user = new User();
		
		//取得したデータを結果返却用の変数に格納]
		
		user.setUserid((String)map.get("user_id"));	//ユーザーID
		
		user.setPassword((String)map.get("user_password"));	//パスワード
		
		
		return user;
	}

	@Override
	public List<User> selectMany() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		
		//user_infoテーブルの件数を全部取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM user_info");
		
		//結果返却用の変数
		List<User> userList = new ArrayList<>();
		
		//取得したデータを結果返却用の変数のListに格納していく	
		for(Map<String, Object> map:getList) {
			
			//Userインスタンスの生成
			User user= new User();
			
			//Userインスタンスに取得したデータをセットする
			
			user.setUserid((String)map.get("user_id"));	//ユーザーID
			
			user.setPassword((String)map.get("user_password"));	//パスワード
			
			userList.add(user);
			
			
		}
		return userList;
		
	}

	@Override
	public int updateOne(User user) throws DataAccessException {
		String password = passwordEncoder.encode(user.getPassword());
		
		int rowNumber = jdbc.update("UPDATE user_info("
				+ "SET "
				+ "user_id"
				+ "user_pssword)"
				+ "VALUES(?,?)"
				,user.getUserid()
				,password);
		
		return rowNumber;
	}

	@Override
	public int deleteOne(String userId) throws DataAccessException {
		int rowNumber = jdbc.update("DELETE FROM user_info("
				+ "WHERE "
				+ "user_id"
				+ "=?"
				
				,userId
				);
		return rowNumber;
	}

	
}
