package com.june.app.board.web;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
import com.june.app.cmn.model.Pagination;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value = "/board/{bbsId}/list/{pageIndex}", method = {RequestMethod.POST, RequestMethod.GET})
	public String getBoardList(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			@PathVariable int pageIndex,
			Model model) {
		logger.debug("=====] call getBoardList [=====");
		/**페이지당 보여주는 게시물 수*/
		board.setPageSize(2);
		/**현재 페이지*/
		board.setPageIndex(pageIndex);
		/**게시판 ID*/
		board.setBbsId(bbsId);
		
		Map<?,?> boardList = boardService.boardListWithPaging(board);
		
		long totalCnt = (long) boardList.get("boardListCnt");
		board.setTotalCnt(totalCnt);
		
		
		model.addAttribute("boardList", boardList.get("boardList") );
		model.addAttribute("boardListCnt", totalCnt );
		
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "/board/{bbsId}/insert", method = RequestMethod.GET)
	public String goBoardInsert(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		logger.debug("=====] call goBoardInsert [=====");
		/**페이지당 보여주는 게시물 수*/
		
		/**게시판 ID*/
		board.setBbsId(bbsId);
		model.addAttribute("bbsId", bbsId );
		return "board/boardInsert";
	}
	
	@RequestMapping(value = "/board/{bbsId}/insertProc", method = RequestMethod.POST)
	public String goBoardInsertProc(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		logger.debug("=====] call goBoardInsertProc [=====");
		/**페이지당 보여주는 게시물 수*/
		
		logger.debug("=====] call goBoardInsertProc [===== {}", board.getNttCn());
		/**게시판 ID*/
		Date today = new Date();
		board.setBbsId(bbsId);
		board.setFrstRegistPnttm(today);
		board.setFrstRegisterId("admin");
		board.setUseYn("Y");
		boardService.save(board);
		return "board/boardList";
	}
	
}
