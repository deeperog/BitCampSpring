package com.umki.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umki.member.model.Message;
import com.umki.member.service.ServiceException;
import com.umki.member.service.WriteMessageService;

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
