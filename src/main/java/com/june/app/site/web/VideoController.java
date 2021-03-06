package com.june.app.site.web;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.june.app.site.model.Video;
import com.june.app.site.service.VideoService;
import com.june.app.user.model.Login;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes(value = "loginInfo")
@Controller
public class VideoController {

	private static final Logger logger = LoggerFactory
			.getLogger(VideoController.class);

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/site/video/list/{pageIndex}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getVideoList(Locale locale,
			@ModelAttribute("video") Video video, @PathVariable int pageIndex,
			Model model) {
		logger.debug("=====] call getVideoList [=====");
		/** 페이지당 보여주는 게시물 수 */
		video.setPageSize(2);
		/** 현재 페이지 */
		video.setPageIndex(pageIndex);
		Map<?, ?> videoList = videoService.videoListWithPaging(video);

		long totalCnt = (long) videoList.get("videoListCnt");
		video.setTotalCnt(totalCnt);

		model.addAttribute("videoList", videoList.get("videoList"));
		model.addAttribute("videoListCnt", totalCnt);

		return "site/videoList";
	}

	@RequestMapping(value = "/site/video/new", method = RequestMethod.GET)
	public String goVideoInsert(Locale locale, Model model) {
		logger.debug("=====] call goVideoInsert [=====");
		model.addAttribute("save", "new");
		return "site/videoSave";
	}

	@RequestMapping(value = "/site/video/new", method = RequestMethod.POST)
	public String goVideoInsertProc(Locale locale, @Valid Video video,
			HttpServletRequest request, BindingResult result,
			SessionStatus status) {
		logger.debug("=====] call goVideoInsertProc [=====");
		if (result.hasErrors()) {
			return "site/videoSave";
		} else {
			Login logininfo = (Login) request.getSession().getAttribute(
					"loginInfo");
			Date today = new Date();
			video.setUseYn("Y");
			video.setRegiDate(today);
			video.setUpdtDate(today);
			video.setRegiId(logininfo.getUserInfo().getSeq());
			videoService.save(video);
			status.setComplete();
			return "redirect:/site/video/list/1";
		}
	}

	@RequestMapping(value = "/site/video/get/{nttId}/{pageIndex}", method = RequestMethod.GET)
	public String getVideoDetail(Locale locale, @PathVariable Integer nttId,
			@PathVariable int pageIndex, Model model) {
		logger.debug("=====] call getVideoDetail [=====");
		Video video = videoService.videoGet(nttId);
		video.setPageIndex(pageIndex);
		model.addAttribute("video", video);
		return "site/videoDetail";
	}

	@RequestMapping(value = "/site/video/update/{nttId}/{pageIndex}", method = RequestMethod.GET)
	public String goVideoUpdate(Locale locale, @PathVariable Integer nttId,
			@PathVariable int pageIndex, Model model) {
		logger.debug("=====] call goVideoInsert [=====");
		Video video = videoService.videoGet(nttId);
		video.setPageIndex(pageIndex);
		model.addAttribute("mode", "update");
		model.addAttribute("video", video);
		return "site/videoSave";
	}

	@RequestMapping(value = "/site/video/update/{pageIndex}", method = RequestMethod.POST)
	public String goVideoUpdateProc(Locale locale, @Valid Video video,
			BindingResult result, @PathVariable int pageIndex,
			HttpServletRequest request, SessionStatus status) {
		logger.debug("=====] call goVideoUpdateProc [=====");
		if (result.hasErrors()) {

			return "site/videoSave";
		} else {
			Login logininfo = (Login) request.getSession().getAttribute(
					"loginInfo");
			Date today = new Date();
			video.setUseYn("Y");
			// video.setRegiDate(today);
			video.setUpdtDate(today);
			video.setUpdtId(logininfo.getUserInfo().getSeq());
			videoService.save(video);
			status.setComplete();
			return "redirect:/site/video/get/" + video.getNttId()
					+ "/{pageIndex}";
		}
	}

}
