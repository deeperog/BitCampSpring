package com.umki.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umki.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	private MemberLoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(value = "no", required=false) String num) {
		return new ModelAndView("member/loginForm");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView loginProcess(
			@RequestParam(value = "userId", required=false) String userId, 
			@RequestParam(value = "password", required=true) String password,
			HttpSession session
			) throws SQLException {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginFail");
		
		if(userId != null && password != null) {
			if(loginService.login(userId, password, session)) {
				modelAndView.setViewName("redirect:/");
			}
			
		}
				
		return modelAndView;
	}
}
