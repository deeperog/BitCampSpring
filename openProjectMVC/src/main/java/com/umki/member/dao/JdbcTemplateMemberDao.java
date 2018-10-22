package com.umki.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.MemberInfo;

public class JdbcTemplateMemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		String insert_sql = "insert into MEMBER (userid, password, username, userphoto) values (?, ?, ?, ?)";
		int resultCnt = 0;

		resultCnt = jdbcTemplate.update(insert_sql, memberInfo.getUserId(), memberInfo.getPassword(),
				memberInfo.getUserName(), memberInfo.getUserPhoto());

		return resultCnt;
	}

	public MemberInfo getMemberInfo(String id) {
		
		String sql = "select * from member where userid=?";
		
		List<MemberInfo> results = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {
			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));
				
				return memberInfo;
			}
		}, id);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	
	public List<MemberInfo> getAllMemberInfo() {
		
		String sql = "select * from member";
		
		List<MemberInfo> results = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {
			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));
				
				return memberInfo;
			}
		});
		
		return results;
	}

	public int updateMember(String id) {
		

		return 0;
	}

}
