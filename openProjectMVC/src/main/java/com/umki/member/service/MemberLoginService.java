package com.umki.member.service;

import java.sql.SQLException;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.dao.MybatisMemberDao;
import com.umki.member.model.MemberInfo;

public class MemberLoginService {

//	@Autowired
//	private JdbcTemplateMemberDao memberDao;
	
//	@Autowired
//	private MybatisMemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;
	
	@Transactional
	public boolean login(String id, String pw, HttpSession session) throws SQLException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);

		boolean result = false;

		MemberInfo memberInfo = memberDao.getMemberInfo(id);

		// 비밀번호 비교
		if (memberInfo != null && memberInfo.getPassword().equals(pw)) {

			// 로그인 처리 : 세션에 사용자 데이터 저장
			memberInfo.setPassword(""); // 세션에 개인정보 저장을 하지 않기 위해

			session.setAttribute("loginInfo", memberInfo);
			result = true;

		}

		return result;
	}
}
