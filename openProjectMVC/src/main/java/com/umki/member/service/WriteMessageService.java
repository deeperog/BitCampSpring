package com.umki.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.model.Message;

public class WriteMessageService {

	@Autowired
	jdbcTemplateMemberDao messageDao;

	public void write(Message message) throws ServiceException {
		try {
			messageDao.insert(message);
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		}
	}
}