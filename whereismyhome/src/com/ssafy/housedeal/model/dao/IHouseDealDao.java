package com.ssafy.housedeal.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.housedeal.model.HouseDealInfo;

public interface IHouseDealDao {
	List<HouseDealInfo> getHouseDeal(String fullCode, String dealYear, String dealMonth) throws SQLException;

	List<HouseDealInfo> getHouseDealFull(String dongCode) throws SQLException;
}
