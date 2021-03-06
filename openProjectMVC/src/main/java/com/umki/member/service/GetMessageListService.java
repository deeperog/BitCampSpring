package com.umki.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.jdbc.ConnectionProvider;
import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.Message;
import com.umki.member.model.MessageListView;

public class GetMessageListService {
	
//	@Autowired
//	JdbcTemplateMemberDao messageDao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	MemberDaoInterface messageDao;

	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) throws ServiceException {
		messageDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		Connection conn = null;
		int currentPageNumber = pageNumber;
		
		try {
			conn = ConnectionProvider.getConnection();

			// 전체 메시지 구하기
			int messageTotalCount = messageDao.selectCount();
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(firstRow-1, 3);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}