package com.bitcamp.mvc1016;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("/cookie/make")
	public String makeCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1"));
		return null;
	}
	
	@RequestMapping("/cookie/view")
	public String viewCookie(@CookieValue(value = "auth", defaultValue = "0") String cookieVal) {
		
		System.out.println("Cookie auth : " + cookieVal);
		return null;
	}
}
