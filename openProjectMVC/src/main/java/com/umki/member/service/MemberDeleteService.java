package com.umki.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;

public class MemberDeleteService {
	
	@Autowired
	JdbcTemplateMemberDao memberDao;

	public int delete(String id, String password) {
		int resultCnt = 0;
		
		resultCnt = memberDao.delete(id, password);
		
		return resultCnt;
		
	}
	
	

}
