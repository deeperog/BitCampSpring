package com.umki.member.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.model.MemberInfo;

public class MemberListService {
	
//	@Autowired
//	private JdbcTemplateMemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;

	@Transactional
	public List<MemberInfo> selectMemberInfo() {
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		
		List<MemberInfo> results = memberDao.getAllMemberInfo();
		
		return results;
	}
	
}
