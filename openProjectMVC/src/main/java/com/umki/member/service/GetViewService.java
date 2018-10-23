package com.umki.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.MessageDao;
import com.umki.member.jdbc.ConnectionProvider;
import com.umki.member.model.Message;

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
