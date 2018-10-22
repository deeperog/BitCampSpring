package com.umki.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberUpdateController {
	@RequestMapping("/member/update/{id}")
	public String getUpdate(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "member/memberUpdate";
	}

}
