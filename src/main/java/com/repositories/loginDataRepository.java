package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.User;

@Repository

public interface loginDataRepository extends JpaRepository<User, String>{

	User findByUserid(String userid) ;


}
