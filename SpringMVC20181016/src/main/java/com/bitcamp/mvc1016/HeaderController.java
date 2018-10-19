package com.bitcamp.mvc1016;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
	@RequestMapping("/header/check")
	public String headerCheck(@RequestHeader("Referer") String url) {
		System.out.println(url);
		
		return "header/pass";
	}
}
