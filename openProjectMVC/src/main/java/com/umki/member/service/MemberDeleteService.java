package com.umki.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDaoInterface;

public class MemberDeleteService {
	
//	@Autowired
//	JdbcTemplateMemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDaoInterface memberDao;

	public int delete(String id, String password) {
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		int resultCnt = 0;
		
		resultCnt = memberDao.delete(id, password);
		
		return resultCnt;
		
	}
	
	

}
