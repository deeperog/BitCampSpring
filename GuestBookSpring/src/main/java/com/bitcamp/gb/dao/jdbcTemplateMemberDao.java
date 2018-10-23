package com.bitcamp.gb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.gb.model.Message;

public class jdbcTemplateMemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(Message message) throws SQLException {
		String sql = "insert into guestbook_message (guest_name, password, message) values (?, ?, ?)";
		jdbcTemplate.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());
	}

	public int selectCount() throws SQLException {
		String sql = "select count(*) from guestbook_message";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		List<Message> resultList = jdbcTemplate.query(sql, new RowMapper<Message>() {
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				
				return message;	
			}
		},firstRow-1, 3);
		
		return resultList.isEmpty() ? null : resultList;

	}

//	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
//		Message message = new Message();
//		message.setId(rs.getInt("message_id"));
//		message.setGuestName(rs.getString("guest_name"));
//		message.setPassword(rs.getString("password"));
//		message.setMessage(rs.getString("message"));
//		return message;
//	}

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

	public void delete(int messageId) throws SQLException {
		String sql = "delete from guestbook_message where message_id = ?";
		jdbcTemplate.update(sql, messageId);
	}
}
