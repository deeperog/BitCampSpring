package com.umki.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;

public class MemberUpdateService {
	
	@Autowired
	JdbcTemplateMemberDao memberDao;
	
	public int updateMember(String id) {
		int resultCnt = 0;
		int resultCnt = memberDao.updateMember(id);
		return 0;
	}

}
