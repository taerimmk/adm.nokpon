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

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board/{bbsId}/list", method = RequestMethod.GET)
	public String home(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		board.setBbsId(bbsId);
		Collection<Board> boardList = boardService.boardList(board);
		
		model.addAttribute("boardList", boardList );
		
		return "board/boardList";
	}
	
}
