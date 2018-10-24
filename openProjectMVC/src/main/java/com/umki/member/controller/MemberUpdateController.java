package com.umki.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umki.member.model.MemberInfo;
import com.umki.member.service.MemberUpdateService;

@Controller
@RequestMapping("/member/update/{id}")
public class MemberUpdateController {

	@Autowired
	MemberUpdateService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getUpdateView(@PathVariable("id") String id, Model model) {
		MemberInfo memberInfo = service.getUpdateMemberInfo(id);
		model.addAttribute("memberInfo", memberInfo);
		return "member/memberUpdate";
	}

	@RequestMapping(method = RequestMethod.POST)

	public String update(MemberInfo memberInfo, @RequestParam("xphoto") String photo, HttpServletRequest request) {
		if(memberInfo.getPhotoFile().getOriginalFilename() == "") {
			memberInfo.setUserPhoto(photo);			
		}
		
		String page = "member/regok";
		int resultCnt = 0;
		try {
			resultCnt = service.updateMemberInfo(memberInfo, request);
			if (resultCnt == 0) {
				page = "member/regFail";
			}
			request.getSession().setAttribute("loginInfo", memberInfo);
		} catch (IllegalStateException | SQLException | IOException e) {
			page = "member/regFail";
			e.printStackTrace();
		}
			
		return page;
	}

}
