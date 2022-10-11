package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.member.model.Member;

public interface MemberService {

//	int idCheck(String userId) throws Exception; //아이디 중복검사
//	void joinMember(Member memberDto) throws Exception; //회원가입
//	Member loginMember(String userId, String userPwd) throws Exception;//로그인
	int regist(Member member) throws Exception;
	Member login(String userId, String userPwd) throws Exception;
	Member findPwd(String userName, String userId) throws Exception;
	Member getInfo(String id) throws Exception;
	int update(Member member) throws Exception;
	List<Member> getList() throws Exception;
	int delete(String id) throws Exception;
}
