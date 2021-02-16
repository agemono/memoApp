package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.loginData;

@Repository

public interface loginDataRepository extends JpaRepository<loginData, String>{

	public  Optional<loginData> findById(String id) ;

}
