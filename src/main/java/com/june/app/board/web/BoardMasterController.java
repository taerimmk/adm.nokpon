package com.june.app.board.web;

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

import com.june.app.board.model.BoardMaster;
import com.june.app.board.service.BoardMasterService;

@Controller
public class BoardMasterController {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardMasterController.class);

	@Autowired
	private BoardMasterService boardMasterService;

	@RequestMapping(value = "/boardMaster/list/{pageIndex}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getBoardMasterList(Locale locale,
			@ModelAttribute("boardMaster") BoardMaster boardMaster,
			@PathVariable int pageIndex, Model model) {
		/** 페이지당 보여주는 게시물 수 */
		boardMaster.setPageSize(10);
		/** 현재 페이지 */
		boardMaster.setPageIndex(pageIndex);

		Map<?, ?> boardMasterList = boardMasterService
				.boardMasterList(boardMaster);

		long totalCnt = (long) boardMasterList.get("boardMasterListCnt");
		boardMaster.setTotalCnt(totalCnt);

		model.addAttribute("boardMstList",
				boardMasterList.get("boardMasterList"));
		model.addAttribute("boardMstListCnt", totalCnt);

		return "board/boardMasterList";
	}

	@RequestMapping(value = "/boardMaster/insert", method = RequestMethod.GET)
	public String goBoardMasterInsert(Locale locale, Model model) {

		return "board/boardMasterInsert";
	}

	@RequestMapping(value = "/boardMaster/insert", method = RequestMethod.POST)
	public String goBoardMasterInsertProc(
			@ModelAttribute("boardMaster") BoardMaster boardMaster,
			HttpServletRequest request, Model model) {

		Date today = new Date();
		boardMaster.setRegiDate(today);
		boardMaster.setUseYn("Y");
		boardMasterService.save(boardMaster);
		return "redirect:/boardMaster/list/1";
	}

	@RequestMapping(value = "/boardMaster/get/{bbsId}/{pageIndex}", method = RequestMethod.GET)
	public String goBoardMasterGet(Locale locale,
			@ModelAttribute("boardMaster") BoardMaster boardMaster,
			@PathVariable int bbsId, @PathVariable int pageIndex, Model model) {

		/** 게시판 ID */
		boardMaster.setPageIndex(pageIndex);
		BoardMaster boardMasterDetail = boardMasterService
				.boardMasterGet(bbsId);
		model.addAttribute("boardMasterDetail", boardMasterDetail);
		return "board/boardMasterDetail";
	}

	@RequestMapping(value = "/boardMaster/update/{bbsId}/{pageIndex}", method = RequestMethod.GET)
	public String goBoardMasterUpdate(Locale locale,
			@ModelAttribute("boardMaster") BoardMaster boardMaster,
			@PathVariable int bbsId, @PathVariable int pageIndex, Model model) {
		boardMaster.setPageIndex(pageIndex);
		BoardMaster boardMasterDetail = boardMasterService
				.boardMasterGet(bbsId);
		model.addAttribute("boardMasterDetail", boardMasterDetail);
		return "board/boardMasterUpdate";
	}

	@RequestMapping(value = "/boardMaster/update/{bbsId}/{pageIndex}", method = RequestMethod.POST)
	public String goBoardMasterUpdateProc(
			@ModelAttribute("boardMaster") BoardMaster boardMaster,
			@PathVariable int bbsId, @PathVariable int pageIndex,
			HttpServletRequest request, Model model) {
		// Date today = new Date();
		// boardMaster.setRegiDate(today);
		boardMasterService.save(boardMaster);
		return "redirect:/boardMaster/get/{bbsId}/{pageIndex}";
	}
}
