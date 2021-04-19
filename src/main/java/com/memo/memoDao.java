package com.memo;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface memoDao {

	public int count() throws DataAccessException ;
	
	public int insert(memoData memo)throws DataAccessException;
	
	public List<memoData> selectAll(String userId)throws DataAccessException;
	
	public memoData updatetAll(String userId)throws DataAccessException;
	
	public memoData delete(String userId)throws DataAccessException;
}
