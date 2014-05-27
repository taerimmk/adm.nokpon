package com.june.app.board.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.board.model.Board;
import com.june.app.board.model.BoardMaster;
import com.june.app.board.repository.BoardMasterRepository;
import com.june.app.board.service.BoardMasterService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author Michael Isvy
 */
@Service
public class BoardMasterServiceImpl implements BoardMasterService {

	@Autowired
	private BoardMasterRepository boardMasterRepository;

	
	@Override
	@Transactional(readOnly = true)
	public Collection<BoardMaster> boardMasterListAll() throws DataAccessException {
		return boardMasterRepository.boardMasterListAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Map<?,?> boardMasterList(BoardMaster vo) throws DataAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardMasterList", boardMasterRepository.boardMasterList(vo));
		map.put("boardMasterListCnt", boardMasterRepository.boardMasterListCnt(vo));
		return map;
	}
	@Override
	@Transactional(readOnly = true)
	public void save (BoardMaster vo) throws DataAccessException {
		boardMasterRepository.save(vo);
	}
}
