package com.umki.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.model.MemberInfo;

public class MemberListService {
	
	@Autowired
	private JdbcTemplateMemberDao memberDao;

	@Transactional
	public List<MemberInfo> selectMemberInfo() {
		List<MemberInfo> results = memberDao.getAllMemberInfo();
		
		return results;
	}
	
}
