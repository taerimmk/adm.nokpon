package com.june.app.board.web;

import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.june.app.board.model.BoardMaster;
import com.june.app.board.service.BoardMasterService;
import com.june.app.board.service.BoardService;
import com.june.app.cmn.model.FileDetail;
import com.june.app.cmn.service.FileService;
import com.june.app.user.model.Login;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardMasterController {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardMasterController.class);

	
	@Autowired
	private BoardMasterService boardMasterService;
	

	@RequestMapping(value = "/boardMaster/list/{pageIndex}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getBoardList(Locale locale,
			@ModelAttribute("boardMst") BoardMaster boardMst,
			@PathVariable int pageIndex, Model model) {
		/** 페이지당 보여주는 게시물 수 */
		boardMst.setPageSize(10);
		/** 현재 페이지 */
		boardMst.setPageIndex(pageIndex);
		/** 게시판 ID */
		
		
		Map<?, ?> boardMasterList = boardMasterService.boardMasterList(boardMst);

		long totalCnt = (long) boardMasterList.get("boardMasterListCnt");
		boardMst.setTotalCnt(totalCnt);

		model.addAttribute("boardMstList", boardMasterList.get("boardMasterList"));
		model.addAttribute("boardListCnt", totalCnt);

		return "board/boardList";
	}

	
}
