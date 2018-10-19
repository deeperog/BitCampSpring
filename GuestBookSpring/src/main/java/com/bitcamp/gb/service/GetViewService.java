package com.bitcamp.gb.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.gb.dao.MessageDao;
import com.bitcamp.gb.jdbc.ConnectionProvider;
import com.bitcamp.gb.model.Message;

public class GetViewService {

	@Autowired
	private MessageDao dao;

	Connection conn = null;

	public Message getInfo(int id) throws SQLException {

		conn = ConnectionProvider.getConnection();
		Message message = dao.select(conn, id);

		return message;
	}
}
