package com.june.app.board.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.board.model.BoardMaster;

public interface BoardMasterRepository {
    
	Collection<BoardMaster> boardMasterListAll() throws DataAccessException;
	
	Collection<BoardMaster> boardMasterList (BoardMaster vo) throws DataAccessException;
	
	long boardMasterListCnt (BoardMaster vo) throws DataAccessException;
	
	void save (BoardMaster vo) throws DataAccessException;

}
