package com.umki.member.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.model.Message;

public class WriteMessageService {

//	@Autowired
//	JdbcTemplateMemberDao messageDao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	MemberDaoInterface messageDao;

	public void write(Message message) {
		messageDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		messageDao.insert(message);
	}
}