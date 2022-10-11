package com.ssafy.housedeal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements IHouseDealDao {
	DBUtil db;
	private static IHouseDealDao dao = new HouseDealDaoImpl();
	
	private HouseDealDaoImpl() {
		super();
		db = DBUtil.getInstance();
	}
	
	public static IHouseDealDao getInstance() {
		return dao;
	}

	@Override
	public List<HouseDealInfo> getHouseDeal(String fullCode, String dealYear, String dealMonth) throws SQLException {
		long longCode = Long.parseLong(fullCode);
		String sql = "SELECT d.no, i.apartmentName, d.floor, d.area, i.dong, d.dealAmount, i.lng, i.lat  \n";
		sql += "FROM  housedeal d join houseinfo i\n";
		sql+= "on d.aptCode = i.aptCode\n";
		sql+="where i.dongCode = ? and d.dealYear= ? and d.dealMonth=?";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<HouseDealInfo> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			int j=1;
			pstmt.setLong(j++, longCode);
			pstmt.setInt(j++, Integer.parseInt(dealYear));
			pstmt.setInt(j++, Integer.parseInt(dealMonth));
			System.out.println(pstmt);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				HouseDealInfo info = new HouseDealInfo();
				info.setApartName(rs.getString("apartmentName"));
				info.setFloor(rs.getString("floor"));
				info.setArea(rs.getString("area"));
				info.setDong(rs.getString("dong"));
				info.setDealAmount(rs.getString("dealAmount"));
				info.setLng(rs.getString("lng"));
				info.setLat(rs.getString("lat"));
				System.out.println(info);
				list.add(info);
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public List<HouseDealInfo> getHouseDealFull(String dongCode) throws SQLException {
		long longCode = Long.parseLong(dongCode);
		String sql = "SELECT d.no, i.apartmentName, d.floor, d.area, i.dong, d.dealAmount\n";
		sql += "FROM  housedeal d join houseinfo i\n";
		sql+= "on d.aptCode = i.aptCode\n";
		sql+="where i.dongCode = ? ";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<HouseDealInfo> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			int j=1;
			pstmt.setLong(j++, longCode);
			System.out.println(pstmt);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				HouseDealInfo info = new HouseDealInfo();
				info.setApartName(rs.getString("apartmentName"));
				info.setFloor(rs.getString("floor"));
				info.setArea(rs.getString("area"));
				info.setDong(rs.getString("dong"));
				info.setDealAmount(rs.getString("dealAmount"));
				System.out.println(info);
				list.add(info);
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

}
