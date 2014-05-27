package com.june.app.board.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.june.app.board.model.Board;


public interface BoardService {
   
	public Map<?,?> boardList(Board vo) throws DataAccessException;
	
	public void save (Board vo) throws DataAccessException;
	
	public Board boardGet (Integer seq) throws DataAccessException;
}
