package com.umki.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.jdbc.ConnectionProvider;
import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.Message;

public class DeleteMessageService {
//	@Autowired
//	JdbcTemplateMemberDao messageDao;
	
	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	MemberDaoInterface messageDao;

	public void deleteMessage(int messageId, String password)
			throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException {
		messageDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Message message = messageDao.select(messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			}
			if (!message.hasPassword()) {
				throw new InvalidMessagePassowrdException();
			}
			if (!message.getPassword().equals(password)) {
				throw new InvalidMessagePassowrdException();
			}
			messageDao.delete1(messageId);
			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 처리 중 에러가 발생했습니다:" + ex.getMessage(), ex);
		} catch (InvalidMessagePassowrdException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} catch (MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(false);
				} catch (SQLException e) {
				}
				JdbcUtil.close(conn);
			}
		}
	}
}