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
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardMasterService boardMasterService;
	@Autowired
	private FileService fileService;
	
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
		Collection<BoardMaster> boardMstList = boardMasterService.boardMasterList();
		//logger.debug("=====] call getBoardList [boardMstList]====={}",boardMstList);
		
		Map<?,?> boardList = boardService.boardListWithPaging(board);
		
		long totalCnt = (long) boardList.get("boardListCnt");
		board.setTotalCnt(totalCnt);
		logger.debug("=====] call getBoardList [boardList]====={}",boardList.get("boardList") );
		logger.debug("=====] call getBoardList [totalCnt]====={}",totalCnt);
		
		model.addAttribute("boardList", boardList.get("boardList") );
		model.addAttribute("boardListCnt", totalCnt );
		model.addAttribute("boardMstList", boardMstList );
		
		
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
	
	@RequestMapping(value = "/board/{bbsId}/insertProc", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public String goBoardInsertProc(
			//MultipartHttpServletRequest request,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			HttpServletRequest request,
			Model model) {
		logger.debug("=====] call goBoardInsertProc [ board.getAtchFileIdFile( ]===={}",board.getAtchFileIdFile());
		/**페이지당 보여주는 게시물 수*/
		if (!board.getAtchFileIdFile().isEmpty()){
		
		FileDetail fileDetail = fileService.fileSaveDB(board.getAtchFileIdFile());
		board.setAtchFileId(fileDetail.getAtchFileId());
		logger.debug("=====] call goBoardInsertProc [===== {}", board.getNttCn());
		}
		
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		/**게시판 ID*/
		Date today = new Date();
		board.setBbsId(bbsId);
		
		board.setRegiDate(today);
		board.setRegiId(logininfo.getUserInfo().getSeq());
		board.setUseYn("Y");
		boardService.save(board);
		return "redirect:/board/{bbsId}/list/1";
	}
	
	@RequestMapping(value = "/board/{bbsId}/get/{seq}", method = RequestMethod.GET)
	public String goBoardGet(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			@PathVariable Integer seq,
			Model model) {
		logger.debug("=====] call goBoardGet [=====");
		
		/**게시판 ID*/
		board.setBbsId(bbsId);
		/**게시물 ID*/
		board.setNttId(seq);
		Board boardDetail = boardService.boardGet(seq);
		model.addAttribute("boardDetail", boardDetail );
		model.addAttribute("bbsId", bbsId );
		return "board/boardDetail";
	}
	
}
