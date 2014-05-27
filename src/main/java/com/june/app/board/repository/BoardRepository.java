package com.june.app.board.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.board.model.Board;

public interface BoardRepository {
    
	Collection<Board> boardList(Board vo) throws DataAccessException;
	
	Collection<Board> boardListWithPaging (Board vo) throws DataAccessException;
	
	long boardListCnt (Board vo) throws DataAccessException;
	
	void save (Board vo) throws DataAccessException;
	
	Board boardGet (Integer seq) throws DataAccessException;

}
