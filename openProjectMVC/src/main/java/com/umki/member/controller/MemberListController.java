package com.umki.member.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.umki.member.model.MemberInfo;
import com.umki.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberList");
		
		List<MemberInfo> results = listService.selectMemberInfo();   
		modelAndView.addObject("list", results);
		
		return modelAndView;
	}
	
	
}
