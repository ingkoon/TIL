package com.ssafy.interest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.member.model.Member;
import com.ssafy.util.DBUtil;

public class InterestDaoImpl implements InterestDao {
	private static InterestDao interestDao = new InterestDaoImpl();
	private DBUtil dbUtil;

	private InterestDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static InterestDao getInterestDao() {
		return interestDao;
	}
	
	@Override
	public List<InterestDto> getList(String user_id) throws SQLException {
		List<InterestDto> interests = new ArrayList<>();
		String sql = " select user_id,dongCode from interest  where user_id =? \n";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = dbUtil.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				InterestDto interestDto =new InterestDto();
				interestDto.setUser_id(rs.getString(1));
				interestDto.setDongCode(rs.getString(2));
				interests.add(interestDto);
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return interests;
	}

	@Override
	public int insert(InterestDto interestDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into interest(user_id, dongCode) \n");
			sql.append(" values(?,?) ");
			psmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			psmt.setString(i++, interestDto.getUser_id());
			psmt.setString(i++, interestDto.getDongCode());

			cnt = psmt.executeUpdate();
		} finally {
			dbUtil.close(psmt, conn);
		}

		return cnt;
	}

	@Override
	public int delete(String user_id, String dongCode) throws SQLException {
		String sql = " delete from interest \n";
		sql+= " where user_id=? and dongCode=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = dbUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			int j = 1;
			
			psmt.setString(1, user_id);
			psmt.setString(2, dongCode);
			count = psmt.executeUpdate();
		} finally {
			dbUtil.close(conn,psmt);
		}
		
		return count;
	}

}
