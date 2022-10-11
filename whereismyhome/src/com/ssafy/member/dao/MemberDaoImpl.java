package com.ssafy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.member.model.Member;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements IMemberDao {
	DBUtil db;
	private static IMemberDao mdao = new MemberDaoImpl();
	
	private MemberDaoImpl() {
		super();
		db = DBUtil.getInstance();
	}
	
	public static IMemberDao getInstance() {
		return mdao;
	}

	@Override
	public int regist(Member member) throws Exception {
		String sql = " insert into members(user_id,password,name,email,age,role,delflag)\n";
		sql+= " values(?,?,?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = db.getConnection();
			psmt = conn.prepareStatement(sql);
			int j = 1;
			psmt.setString(j++, member.getUserId());
			psmt.setString(j++, member.getUserPwd());
			psmt.setString(j++, member.getUserName());
			psmt.setString(j++, member.getEmail());
			psmt.setInt(j++, member.getAge());
			psmt.setString(j++, member.getRole());
			psmt.setInt(j++, member.getDelflag());
			count = psmt.executeUpdate();
		} finally {
			db.close(conn,psmt);
		}
		
		return count;
	}


	@Override
	public Member login(String userId, String userPwd) throws Exception {
		String sql = "select user_id, name, role from members \n";
		sql+="where user_id=? and password =?";
		
		Member member = null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setUserId(rs.getString("user_id"));
				member.setUserName(rs.getString("name"));
				member.setRole(rs.getString("role"));
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return member;
	}

	@Override
	public Member findPwd(String userName, String userId) throws Exception {
		System.out.println(userName+" "+userId);
		String sql = "select password from members \n";
		sql+="where name =? and user_id=?";
		
		Member member = null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, userName);
			pstmt.setString(2, userId);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setUserPwd(rs.getString("password"));
				System.out.println(member.toString());
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return member;
	}

	@Override
	public Member getInfo(String id) throws Exception {
		System.out.println(id);
		String sql = "select user_id, name, age, email from members \n";
		sql+="where user_id=?";
		Member member = null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setUserId(rs.getString("user_id"));
				member.setUserName(rs.getString("name"));
				member.setAge(Integer.parseInt(rs.getString("age")));
				member.setEmail(rs.getString("email"));
				System.out.println(member.toString());
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return member;
	}

	@Override
	public int update(Member member) throws Exception {
		String sql = " update members set user_id=?,password=?,name=?,email=?,age=?,role=?,delflag=0 \n";
		sql+= " where user_id=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = db.getConnection();
			psmt = conn.prepareStatement(sql);
			int j = 1;
			psmt.setString(j++, member.getUserId());
			psmt.setString(j++, member.getUserPwd());
			psmt.setString(j++, member.getUserName());
			psmt.setString(j++, member.getEmail());
			psmt.setInt(j++, member.getAge());
			psmt.setString(j++, member.getRole());
			
			psmt.setString(j++, member.getUserId());
			System.out.println(psmt);
			count = psmt.executeUpdate();
		} finally {
			db.close(conn,psmt);
		}
		
		return count;
	}

	@Override
	public List<Member> getList() throws Exception {
		List<Member> members = new ArrayList<>();
		String sql = "select user_id, name, age ,role, delFlag from members \n";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				Member member=new Member();
				member.setUserId(rs.getString("user_id"));
				member.setUserName(rs.getString("name"));
				member.setAge(Integer.parseInt(rs.getString("age")));
				member.setRole(rs.getString("role"));
				member.setDelflag(Integer.parseInt(rs.getString("delFlag")));
				System.out.println(member.toString());
				members.add(member);
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return members;
	}

	@Override
	public int delete(String id) throws Exception{
		String sql = " update members set delflag=1 \n";
		sql+= " where user_id=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = db.getConnection();
			psmt = conn.prepareStatement(sql);
			int j = 1;
			
			psmt.setString(1, id);
			System.out.println(psmt);
			count = psmt.executeUpdate();
		} finally {
			db.close(conn,psmt);
		}
		
		return count;
	}

}
