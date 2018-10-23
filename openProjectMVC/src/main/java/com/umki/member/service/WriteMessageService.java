package com.umki.member.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.model.Message;

public class WriteMessageService {

	@Autowired
	JdbcTemplateMemberDao messageDao;

	public void write(Message message) {
		messageDao.insert(message);
	}
}