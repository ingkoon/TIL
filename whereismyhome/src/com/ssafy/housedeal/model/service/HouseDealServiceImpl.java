package com.ssafy.housedeal.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dong.model.dao.DongDaoImpl;
import com.ssafy.dong.model.dao.IDongDao;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.housedeal.model.dao.HouseDealDaoImpl;
import com.ssafy.housedeal.model.dao.IHouseDealDao;

public class HouseDealServiceImpl implements IHouseDealService {

	private static IHouseDealService service = new HouseDealServiceImpl();
	private IHouseDealDao dao;
	private HouseDealServiceImpl(){
		dao= HouseDealDaoImpl.getInstance();
	}
	public static IHouseDealService getInstance() {
		return service;
	}
	@Override
	public List<HouseDealInfo> getHouseDeal(String fullCode, String dealYear, String dealMonth) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getHouseDeal(fullCode, dealYear, dealMonth);
	}
	@Override
	public List<HouseDealInfo> getHouseDealFull(String dongCode) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getHouseDealFull(dongCode);
	}

}
