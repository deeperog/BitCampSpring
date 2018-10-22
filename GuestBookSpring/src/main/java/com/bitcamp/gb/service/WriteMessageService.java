package com.bitcamp.gb.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bitcamp.gb.dao.jdbcTemplateMemberDao;
import com.bitcamp.gb.model.Message;

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