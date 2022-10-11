package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.member.dao.IMemberDao;
import com.ssafy.member.dao.MemberDaoImpl;
import com.ssafy.member.model.Member;

public class MemberServiceImpl implements MemberService {
	private static MemberService memberService = new MemberServiceImpl();
	private IMemberDao mdao;
	private MemberServiceImpl(){
		mdao= MemberDaoImpl.getInstance();
	}
	public static MemberService getMemberService() {
		return memberService;
	}
	@Override
	public int regist(Member member) throws Exception {
		return mdao.regist(member);
	}
	@Override
	public Member login(String userId, String userPwd) throws Exception {
		// TODO Auto-generated method stub
		return mdao.login(userId,userPwd);
	}
	@Override
	public Member findPwd(String userName, String userId) throws Exception {
		// TODO Auto-generated method stub
		return  mdao.findPwd(userName,userId);
	}
	@Override
	public Member getInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return mdao.getInfo(id);
	}
	@Override
	public int update(Member member) throws Exception {
		// TODO Auto-generated method stub
		return mdao.update(member);
	}
	@Override
	public List<Member> getList() throws Exception {
		return mdao.getList();
		
	}
	@Override
	public int delete(String id) throws Exception{
		return mdao.delete(id);
	}
	
//	@Override
//	public int idCheck(String userId) throws Exception {
//		return memberDao.idCheck(userId);
//	}
//
//	@Override
//	public void joinMember(MemberDto memberDto) throws Exception {
//		memberDao.joinMember(memberDto);
//	}
//
//	@Override
//	public MemberDto loginMember(String userId, String userPwd) throws Exception {
//		return memberDao.loginMember(userId, userPwd);
//	}

}
