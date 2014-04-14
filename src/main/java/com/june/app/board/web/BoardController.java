package com.june.app.board.web;

import java.util.Collection;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.june.app.board.model.Board;
import com.june.app.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value = "/board/{bbsId}/list/{pageNumber}", method = RequestMethod.GET)
	public String getBoardList(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			@PathVariable int pageNumber,
			Model model) {
		logger.debug("=====] call getBoardList [=====");
		/**페이지당 보여주는 게시물 수*/
		board.setPageSize(2);
		/**현재 페이지*/
		board.setPageNumber(pageNumber);
		/**게시판 ID*/
		board.setBbsId(bbsId);
		
		Collection<Board> boardList = boardService.boardListWithPaging(board);
		
		model.addAttribute("boardList", boardList );
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "/board/{bbsId}/Insert", method = RequestMethod.GET)
	public String goBoardInsert(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		logger.debug("=====] call goBoardInsert [=====");
		/**페이지당 보여주는 게시물 수*/
		
		/**게시판 ID*/
		board.setBbsId(bbsId);
		
		return "board/boardInsert";
	}
	
}
