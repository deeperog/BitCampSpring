package com.umki.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.MemberInfo;
import com.umki.member.model.Message;

public class MybatisMemberDao {
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String mapperPath = "com.umki.member.mapper.mybatis.MemberMapper";

	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		return sqlSessionTemplate.update(mapperPath+".insertMember", memberInfo);
	}

	public MemberInfo getMemberInfo(String id) {
		return sqlSessionTemplate.selectOne(mapperPath+".selectById", id);
	}

//	public List<MemberInfo> getAllMemberInfo() {
//
//		String sql = "select * from member";
//
//		List<MemberInfo> results = sqlSessionTemplate.query(sql, new RowMapper<MemberInfo>() {
//			@Override
//			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberInfo memberInfo = new MemberInfo();
//				memberInfo.setUserId(rs.getString("userid"));
//				memberInfo.setPassword(rs.getString("password"));
//				memberInfo.setUserName(rs.getString("username"));
//				memberInfo.setUserPhoto(rs.getString("userphoto"));
//
//				return memberInfo;
//			}
//		});
//		return results;
//	}
//
//	public int updateMemberInfo(MemberInfo memberInfo, String id) throws SQLException {
//		String sql = "update member	set userId = ?, password = ?, username = ?, userphoto = ? where userid = ?";
//		int resultCnt = 0;
//
//		resultCnt = jdbcTemplate.update(sql, memberInfo.getUserId(), memberInfo.getPassword(), memberInfo.getUserName(),
//				memberInfo.getUserPhoto(), id);
//
//		return resultCnt;
//	}
//
//	public int delete(String id, String password) {
//		String sql = "delete from member where userid=? and password=?";
//		int resultCnt = 0;
//
//		resultCnt = jdbcTemplate.update(sql, id, password);
//		return resultCnt;
//	}
//
//	public Message select(int messageId) throws SQLException {
//
//		String sql = "select * from guestbook_message where message_id = ?";
//
//		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {
//			@Override
//			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Message message = new Message();
//				message.setId(rs.getInt("message_id"));
//				message.setGuestName(rs.getString("guest_name"));
//				message.setPassword(rs.getString("password"));
//				message.setMessage(rs.getString("message"));
//				return message;
//
//			}
//		}, messageId);
//
//		return results.isEmpty() ? null : results.get(0);
//
//	}
//
//	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
//		Message message = new Message();
//		message.setId(rs.getInt("message_id"));
//		message.setGuestName(rs.getString("guest_name"));
//		message.setPassword(rs.getString("password"));
//		message.setMessage(rs.getString("message"));
//		return message;
//	}
//
//	public int delete(int messageId) {
//		String sql = "delete from guestbook_message where message_id = ?";
//		int resultCnt = 0;
//		resultCnt = jdbcTemplate.update(sql, messageId);
//		return resultCnt;
//		
//	}
//
//	public int selectCount() {
//		String sql = "select count(*) from guestbook_message";
//		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//		
//		return count;
//	}
//
//	public List<Message> selectList(int firstRow, int endRow) {
//		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
//		
//		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {
//			@Override
//			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Message message = new Message();
//				message.setId(rs.getInt("message_id"));
//				message.setGuestName(rs.getString("guest_name"));
//				message.setPassword(rs.getString("password"));
//				message.setMessage(rs.getString("message"));
//				return message;
//
//			}
//		}, endRow, 3);
//
//		return results;
//
//	}
//
//	public void insert(Message message) {
//		String sql = "insert into guestbook_message (guest_name, password, message) values (?, ?, ?)";
//		jdbcTemplate.update(sql,message.getGuestName(), message.getPassword(), message.getMessage());
//	}
}
