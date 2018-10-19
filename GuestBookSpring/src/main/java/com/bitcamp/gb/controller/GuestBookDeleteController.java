package com.bitcamp.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.gb.service.DeleteMessageService;
import com.bitcamp.gb.service.InvalidMessagePassowrdException;
import com.bitcamp.gb.service.MessageNotFoundException;
import com.bitcamp.gb.service.ServiceException;

@Controller
@RequestMapping("/guest/delete")
public class GuestBookDeleteController {

	@Autowired
	private DeleteMessageService deleteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getDeleteForm(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("guestbook/confirmDeletion");
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getDelete(@RequestParam("id") int id, @RequestParam("password") String password) {
		String viewName = "redirect:/guest/list";

		try {
			deleteService.deleteMessage(id, password);
		} catch (ServiceException e) {
			viewName="guest/error";
		} catch (InvalidMessagePassowrdException e) {
			viewName="redirect:/guest/delete?id="+id;
		} catch (MessageNotFoundException e) {
			viewName="redirect:/guest/list";
		}

		return viewName;
	}
}
