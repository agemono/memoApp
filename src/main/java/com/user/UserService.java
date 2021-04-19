package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.UserDaojdbc;

@Transactional
@Service
public class UserService {
	
	@Qualifier("UserDaojdbcImpl")
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
