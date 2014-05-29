package com.june.app.board.web;

import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardMasterService boardMasterService;
	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/board/{bbsId}/list/{pageIndex}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getBoardList(Locale locale,
			@ModelAttribute("board") Board board,
			@ModelAttribute("boardMst") BoardMaster boardMst,
			@PathVariable int bbsId, @PathVariable int pageIndex, Model model) {
		/** 페이지당 보여주는 게시물 수 */
		board.setPageSize(10);
		/** 현재 페이지 */
		board.setPageIndex(pageIndex);
		/** 게시판 ID */
		board.setBbsId(bbsId);
		/** 관리자 셀렉트 박스용 */
		Collection<BoardMaster> boardMstList = boardMasterService
				.boardMasterListAll();

		Map<?, ?> boardList = boardService.boardList(board);

		long totalCnt = (long) boardList.get("boardListCnt");
		board.setTotalCnt(totalCnt);

		model.addAttribute("boardList", boardList.get("boardList"));
		model.addAttribute("boardListCnt", totalCnt);
		model.addAttribute("boardMstList", boardMstList);

		return "board/boardList";
	}

	@RequestMapping(value = "/board/{bbsId}/insert", method = RequestMethod.GET)
	public String goBoardInsert(Locale locale,
			@ModelAttribute("board") Board board, @PathVariable int bbsId,
			Model model) {

		/** 게시판 ID */
		board.setBbsId(bbsId);
		model.addAttribute("bbsId", bbsId);
		return "board/boardInsert";
	}

	@RequestMapping(value = "/board/{bbsId}/insert", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String goBoardInsertProc(
			@Valid @ModelAttribute("board") Board board, BindingResult result,
			@PathVariable int bbsId, HttpServletRequest request, Model model) {

		Login logininfo = (Login) request.getSession()
				.getAttribute("loginInfo");
		if (logininfo == null || !logininfo.isLogin()) {
			return "board/boardInsert";
		}

		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "board/boardInsert";
		} else {

			if (board.getAtchFileIdFile() != null) {
				FileDetail fileDetail = fileService.fileSaveDB(board
						.getAtchFileIdFile());
				board.setAtchFileId(fileDetail.getAtchFileId());
			}

			/** 게시판 ID */
			Date today = new Date();
			board.setBbsId(bbsId);

			board.setRegiDate(today);
			board.setRegiId(logininfo.getUserInfo().getSeq());
			board.setUseYn("Y");
			boardService.save(board);
		}
		return "redirect:/board/{bbsId}/list/1";
	}

	@RequestMapping(value = "/board/{bbsId}/get/{seq}", method = RequestMethod.GET)
	public String goBoardGet(Locale locale,
			@ModelAttribute("board") Board board, @PathVariable int bbsId,
			@PathVariable Integer seq, Model model) {

		/** 게시판 ID */
		board.setBbsId(bbsId);
		/** 게시물 ID */
		board.setNttId(seq);
		Board boardDetail = boardService.boardGet(seq);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("bbsId", bbsId);
		return "board/boardDetail";
	}

}
