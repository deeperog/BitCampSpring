package com.umki.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.umki.member.model.MessageListView;
import com.umki.member.service.GetMessageListService;
import com.umki.member.service.ServiceException;

@Controller
public class GuestBookListController {

	@Autowired
	private GetMessageListService service;

	@RequestMapping("/guest/list")
	public ModelAndView getGuestList(HttpServletRequest request) throws ServiceException {
		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		MessageListView viewData = service.getMessageList(pageNumber);
		ModelAndView modelAndView = new ModelAndView();
		// viewName 설정
		modelAndView.setViewName("guestbook/list");

		// view에 결과 데이터 전달(공유)
		modelAndView.addObject("viewData", viewData);
		return modelAndView;
	}

	
}

/*
 * @RequestMapping("/guestbook/list") public ModelAndView
 * getList(@RequestParam(value="page", defaultValue="1") int pageNumber) throws
 * ServiceException { ModelAndView modelAndView = new ModelAndView();
 * modelAndView.setViewName("guestbook/list");
 * 
 * MessageListView listView = service.getMessageList(pageNumber);
 * modelAndView.addObject("listView", listView);
 * 
 * return modelAndView; }
 */