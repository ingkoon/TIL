package com.ssafy.member.dao;

import java.util.List;

import com.ssafy.member.model.Member;

public interface IMemberDao {
	int regist(Member member) throws Exception;
	Member login(String userId,String userPwd) throws Exception;
	Member findPwd(String userName,String userId) throws Exception;
	Member getInfo(String id) throws Exception;
	int update(Member member)throws Exception;
	List<Member> getList() throws Exception;
	int delete(String id)throws Exception;
}
