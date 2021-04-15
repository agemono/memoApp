package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jdbc.UserDaojdbc;

@Service
public class UserService {
	
	@Qualifier("UserDaojdbcImpl2")
	@Autowired
	UserDaojdbc dao;
	
	public boolean insert(User user) {
		int rowNumber = dao.insertOne(user);
		
		boolean result = false;
		
		if(rowNumber > 0) {
			result= true;
		}
		
		return result;
	}

	
}
