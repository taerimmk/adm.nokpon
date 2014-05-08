package com.june.app.site.web;

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

import com.june.app.site.model.Video;
import com.june.app.site.service.VideoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class VideoController {
	
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value = "/site/video/list/{pageIndex}", method = {RequestMethod.POST, RequestMethod.GET})
	public String getVideoList(Locale locale,
			@ModelAttribute("video") Video video,
			@PathVariable int pageIndex,
			Model model) {
		logger.debug("=====] call getBoardList [=====");
		/**페이지당 보여주는 게시물 수*/
		video.setPageSize(2);
		/**현재 페이지*/
		video.setPageIndex(pageIndex);
		
		
		Map<?,?> videoList = videoService.videoListWithPaging(video);
		
		long totalCnt = (long) videoList.get("videoListCnt");
		video.setTotalCnt(totalCnt);
		logger.debug("=====] call getBoardList [videoList]====={}",videoList.get("videoList") );
		logger.debug("=====] call getBoardList [totalCnt]====={}",totalCnt);
		
		model.addAttribute("videoList", videoList.get("videoList") );
		model.addAttribute("videoListCnt", totalCnt );
		
		return "site/videoList";
	}
	
	/*@RequestMapping(value = "/board/{bbsId}/insert", method = RequestMethod.GET)
	public String goBoardInsert(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		logger.debug("=====] call goBoardInsert [=====");
		*//**페이지당 보여주는 게시물 수*//*
		
		*//**게시판 ID*//*
		board.setBbsId(bbsId);
		model.addAttribute("bbsId", bbsId );
		return "board/boardInsert";
	}
	
	@RequestMapping(value = "/board/{bbsId}/insertProc", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public String goBoardInsertProc(
			//MultipartHttpServletRequest request,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			Model model) {
		logger.debug("=====] call goBoardInsertProc [ board.getAtchFileIdFile( ]===={}",board.getAtchFileIdFile());
		*//**페이지당 보여주는 게시물 수*//*
		if (!board.getAtchFileIdFile().isEmpty()){
		
		FileDetail fileDetail = fileService.fileSaveDB(board.getAtchFileIdFile());
		board.setAtchFileId(fileDetail.getAtchFileId());
		logger.debug("=====] call goBoardInsertProc [===== {}", board.getNttCn());
		}
		*//**게시판 ID*//*
		Date today = new Date();
		board.setBbsId(bbsId);
		
		board.setFrstRegistPnttm(today);
		board.setFrstRegisterId("admin");
		board.setUseYn("Y");
		boardService.save(board);
		return "redirect:/board/{bbsId}/list/1";
	}
	
	@RequestMapping(value = "/board/{bbsId}/get/{seq}", method = RequestMethod.GET)
	public String goBoardGet(Locale locale,
			@ModelAttribute("board") Board board,
			@PathVariable int bbsId,
			@PathVariable long seq,
			Model model) {
		logger.debug("=====] call goBoardGet [=====");
		
		*//**게시판 ID*//*
		board.setBbsId(bbsId);
		*//**게시물 ID*//*
		board.setNttId(seq);
		Board boardDetail = boardService.boardGet(seq);
		model.addAttribute("boardDetail", boardDetail );
		model.addAttribute("bbsId", bbsId );
		return "board/boardDetail";
	}*/
	
}
