package com.umki.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umki.member.service.MemberDeleteService;

@Controller
@RequestMapping("/member/delete")
public class MemberDeleteController {
	
	@Autowired
	MemberDeleteService deleteService;

	@RequestMapping(method=RequestMethod.GET)
	public String getDeleteView(@RequestParam("id") String id, Model model) {
		model.addAttribute("idz", id);
		return "member/memberDelete";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String delete(/*@RequestParam("id") String id, @RequestParam("password") String password, */HttpServletRequest request) {
//		System.out.println(id); // @RequestParam으로 받아왔을때 test,test 처럼 나옴 (질문)
		int resultCnt = 0;
		
		String page = "member/memberDelete";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		resultCnt = deleteService.delete(id, password);
		
		if(resultCnt != 0) {
			page = "index";
			request.getSession().invalidate();
		}
		
		return page;
	}
}
