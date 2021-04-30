package com.login;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdbc.UserDaojdbc;
import com.user.User;

@Service
public class LoginUserDetailService implements UserDetailsService{

	@Qualifier("UserDaojdbcImpl")
	UserDaojdbc dao;
	
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
	
		try {
			User user =  dao.selectOne(user_id);
			
			return new LoginUserDetail(user);
		}
		catch(UsernameNotFoundException e) {
			throw new UsernameNotFoundException("user not found", e);
        
		}
	}

	
	
}
