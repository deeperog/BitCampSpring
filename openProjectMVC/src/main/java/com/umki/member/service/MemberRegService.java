package com.umki.member.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.dao.MemberDao;
import com.umki.member.dao.MemberDaoInterface;
import com.umki.member.dao.MybatisMemberDao;
import com.umki.member.jdbc.ConnectionProvider;
import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.MemberInfo;

public class MemberRegService {
	
//	@Autowired
//	private MemberDao memberDao;

//	@Autowired
//	private JdbcTemplateMemberDao memberDao;
	
//	@Autowired
//	private MybatisMemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;

	@Transactional
	public int memberReg(MemberInfo memberInfo, HttpServletRequest request)
			throws SQLException, IllegalStateException, IOException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);

//		conn = ConnectionProvider.getConnection();
		int resultCnt = 0;

		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		// uploadUri 경로의 시스템경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!memberInfo.getPhotoFile().isEmpty()) {
			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));

			// DB에 저장할 이름 set
			memberInfo.setUserPhoto(imgName);
		}

//		try {
//			conn.setAutoCommit(false);
//			resultCnt = memberDao.insertMemberInfo(conn/*컨넥션을 넘기는 이유는 트랜잭션 처리 때문에*/, memberInfo);
		resultCnt = memberDao.insertMemberInfo(memberInfo);

		System.out.println("Service의 신규 회원의 IDX 값 : " + memberInfo.getIdx());

//			conn.commit();
//		} catch (Exception e) {
//			JdbcUtil.rollback(null);
//			throw e;
//		} finally {
//			conn.setAutoCommit(true);
//			JdbcUtil.close(conn);
//		}

		return resultCnt;
	}
}