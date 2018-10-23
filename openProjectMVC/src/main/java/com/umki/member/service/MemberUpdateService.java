package com.umki.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.umki.member.dao.JdbcTemplateMemberDao;
import com.umki.member.model.MemberInfo;

public class MemberUpdateService {
	
	@Autowired
	JdbcTemplateMemberDao memberDao;
	
	@Transactional
	public MemberInfo getUpdateMemberInfo(String id) {
		MemberInfo memberInfo = memberDao.getMemberInfo(id);
		return memberInfo;
	}
	
	@Transactional
	public int updateMemberInfo(MemberInfo memberInfo, String id, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
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
		
		int resultCnt = memberDao.updateMemberInfo(memberInfo, id);
		
		return resultCnt;
	}

}
