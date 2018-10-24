package com.umki.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.umki.member.model.MemberInfo;
import com.umki.member.model.Message;

public interface MemberDaoInterface {
	public MemberInfo getMemberInfo(String id);
	public int insertMemberInfo(MemberInfo memberInfo);
	public List<MemberInfo> getAllMemberInfo();
	public MemberInfo updateMemberInfo(String id);
	public int updateMemberInfo(MemberInfo memberInfo);
	public int delete1(int messageId);
	public int delete(@Param("id") String id, @Param("password")String password);
	public Message select(int messageId);
	public int selectCount();
	public List<Message> selectList(@Param("firstRow") int firstRow, @Param("endRow") int endRow);
	public void insert(Message message);
}
