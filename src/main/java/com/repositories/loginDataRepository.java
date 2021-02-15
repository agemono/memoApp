package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.loginData;

@Repository

public interface loginDataRepository extends JpaRepository<loginData, String>{
	
}
