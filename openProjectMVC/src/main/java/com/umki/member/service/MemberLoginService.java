package com.umki.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.umki.member.dao.MemberDao;
import com.umki.member.jdbc.ConnectionProvider;
import com.umki.member.model.MemberInfo;

public class MemberLoginService {

	@Autowired
	private MemberDao memberDao;

	public boolean login(String id, String pw, HttpSession session) throws SQLException {

		Connection conn = ConnectionProvider.getConnection();

		boolean result = false;

		MemberInfo memberInfo = memberDao.getMemberInfo(conn, id);

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
