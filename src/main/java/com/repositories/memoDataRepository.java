package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memo.memoData;

@Repository
public interface memoDataRepository extends JpaRepository<memoData, String>{

	Optional<memoData> findById(String id) ;
}
