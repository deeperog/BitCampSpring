package com.umki.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umki.member.model.Message;
import com.umki.member.service.GetViewService;


@Controller
public class GuestBookViewController {
	
	@Autowired
	private GetViewService viewService;
	
	@RequestMapping("/guest/view/{id}")
	public String getView(@PathVariable("id") int id, Model model) {
		Message message = null;
		try {
			message = viewService.getInfo(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", message);
		System.out.println(message);
		return "guestbook/view";
	}
}
