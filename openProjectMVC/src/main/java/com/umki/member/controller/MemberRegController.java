package com.umki.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umki.member.model.MemberInfo;
import com.umki.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberRegForm");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView memberReg(MemberInfo member, HttpServletRequest request)/*이미 디스패처 서블릿에서 공유하고 있음*/ {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/regok");
		
		try {
			int resultCnt = regService.memberReg(member, request);
			System.out.println("controller 신규 회원의 IDX값"+member.getIdx());
			if(resultCnt==0) {
				modelAndView.setViewName("member/regFail");
			}
		} catch (SQLException e) {
			modelAndView.setViewName("member/regFail");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			modelAndView.setViewName("member/regFail");
			e.printStackTrace();
		} catch (IOException e) {
			modelAndView.setViewName("member/regFail");
			e.printStackTrace();
		} catch (Exception e) {
			modelAndView.setViewName("member/regFail");
			e.printStackTrace();
		}
		
		return modelAndView;
	}
}
