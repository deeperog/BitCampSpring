package com.umki.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestBookController {

	@RequestMapping("/guest/home")
	public String getGuestBook() {
		return "home";
	}

}
