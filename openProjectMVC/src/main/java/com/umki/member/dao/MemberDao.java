package com.umki.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.MemberInfo;

public class MemberDao {

	public int insertMemberInfo(Connection conn, MemberInfo memberInfo) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String insert_sql = "insert into MEMBER (userid, password, username, userphoto) values (?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, memberInfo.getUserId());
			pstmt.setString(2, memberInfo.getPassword());
			pstmt.setString(3, memberInfo.getUserName());
			pstmt.setString(4, memberInfo.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	public MemberInfo getMemberInfo(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid=?";
		MemberInfo memberInfo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return memberInfo;
	}

}
