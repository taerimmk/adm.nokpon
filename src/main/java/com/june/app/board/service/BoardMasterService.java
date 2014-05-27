package com.june.app.board.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.june.app.board.model.BoardMaster;


public interface BoardMasterService {
   
	public Collection<BoardMaster> boardMasterListAll() throws DataAccessException;
	public Map<?,?> boardMasterList(BoardMaster vo) throws DataAccessException;
	public void save (BoardMaster vo) throws DataAccessException;

}
