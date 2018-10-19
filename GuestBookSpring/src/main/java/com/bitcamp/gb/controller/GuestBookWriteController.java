package com.bitcamp.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.gb.model.Message;
import com.bitcamp.gb.service.ServiceException;
import com.bitcamp.gb.service.WriteMessageService;

@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWriteForm() {
		return "guestbook/writeMessage";
	}
	
	
	
	@Autowired
	private WriteMessageService writeService;

	@RequestMapping(method=RequestMethod.POST)
	public String getWrite(Message message) throws ServiceException {
		writeService.write(message);
		return "guestbook/write";
	}
}
