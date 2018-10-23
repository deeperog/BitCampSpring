package com.umki.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.umki.member.jdbc.JdbcUtil;
import com.umki.member.model.MemberInfo;
import com.umki.member.model.Message;

public class JdbcTemplateMemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		String insert_sql = "insert into MEMBER (userid, password, username, userphoto) values (?, ?, ?, ?)";
		int resultCnt = 0;

		KeyHolder keyholder = new GeneratedKeyHolder();

		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(insert_sql, new String[] { "idx" });
				pstmt.setString(1, memberInfo.getUserId());
				pstmt.setString(2, memberInfo.getPassword());
				pstmt.setString(3, memberInfo.getUserName());
				pstmt.setString(4, memberInfo.getUserPhoto());

				return pstmt;
			}
		}, keyholder);

		Number keyValue = keyholder.getKey();

		memberInfo.setIdx(keyValue.intValue());

//		resultCnt = jdbcTemplate.update(insert_sql, memberInfo.getUserId(), memberInfo.getPassword(),
//				memberInfo.getUserName(), memberInfo.getUserPhoto());

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

	public int updateMemberInfo(MemberInfo memberInfo, String id) throws SQLException {
		String sql = "update member	set userId = ?, password = ?, username = ?, userphoto = ? where userid = ?";
		int resultCnt = 0;

		resultCnt = jdbcTemplate.update(sql, memberInfo.getUserId(), memberInfo.getPassword(), memberInfo.getUserName(),
				memberInfo.getUserPhoto(), id);

		return resultCnt;
	}

	public int delete(String id, String password) {
		String sql = "delete from member where userid=? and password=?";
		int resultCnt = 0;

		resultCnt = jdbcTemplate.update(sql, id, password);
		return resultCnt;
	}

	public Message select(int messageId) throws SQLException {

		String sql = "select * from guestbook_message where message_id = ?";

		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				return message;

			}
		}, messageId);

		return results.isEmpty() ? null : results.get(0);

	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int delete(int messageId) {
		String sql = "delete from guestbook_message where message_id = ?";
		int resultCnt = 0;
		resultCnt = jdbcTemplate.update(sql, messageId);
		return resultCnt;
		
	}

	public int selectCount() {
		String sql = "select count(*) from guestbook_message";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return count;
	}

	public List<Message> selectList(int firstRow, int endRow) {
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				return message;

			}
		}, endRow, 3);

		return results;

	}

	public void insert(Message message) {
		String sql = "insert into guestbook_message (guest_name, password, message) values (?, ?, ?)";
		jdbcTemplate.update(sql,message.getGuestName(), message.getPassword(), message.getMessage());
	}
}
