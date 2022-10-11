package com.ssafy.dong.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dong.model.Dong;
import com.ssafy.util.DBUtil;

public class DongDaoImpl implements IDongDao {
	DBUtil db;
	private static IDongDao ddao = new DongDaoImpl();
	
	private DongDaoImpl() {
		super();
		db = DBUtil.getInstance();
	}
	
	public static IDongDao getInstance() {
		return ddao;
	}

	@Override
	public List<String> getSidoNames() throws SQLException {
		String sql = "select sidoName from dongcode \n";
		sql+="where gugunName is null";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<String> list = new ArrayList<String>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("sidoName"));
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public List<String> getGugunNames(String sidoName) throws SQLException {
		String sql = "select gugunName from dongcode \n";
		sql+="where sidoName = ? and gugunName is not null and dongName is null";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<String> list = new ArrayList<String>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, sidoName);
			System.out.println(pstmt);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("gugunName"));
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public List<Dong> getDongNames(Dong dong) throws SQLException {
		System.out.println("겟동들어옴");
		String sql = "select dongCode, dongName from dongcode \n";
		sql+="where sidoName =? and gugunName=? and dongName is not null";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Dong> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, dong.getSidoName());
			pstmt.setString(2, dong.getGugunName());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				Dong newDong = new Dong();
				newDong.setDongCode(rs.getString("dongCode"));
				newDong.setDongName(rs.getString("dongName"));
				list.add(newDong);
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public Dong select(String dongCode) throws SQLException {
		String sql = " select dongCode,sidoName,gugunName,dongName from dongcode \n";
		sql+=" where dongCode =? ";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Dong dong = null;
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, dongCode);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				int i=1;
				dong =new Dong();
				dong.setDongCode(rs.getString(i++));
				dong.setSidoName(rs.getString(i++));
				dong.setGugunName(rs.getString(i++));
				dong.setDongName(rs.getString(i++));
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return dong;
	}
	
}
