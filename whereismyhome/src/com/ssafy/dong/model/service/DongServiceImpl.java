package com.ssafy.dong.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.dao.DongDaoImpl;
import com.ssafy.dong.model.dao.IDongDao;

public class DongServiceImpl implements IDongService {
	private static IDongService dservice = new DongServiceImpl();
	private IDongDao ddao;
	private DongServiceImpl(){
		ddao= DongDaoImpl.getInstance();
	}
	public static IDongService getInstance() {
		return dservice;
	}
	@Override
	public List<String> getSidoNames() throws SQLException {
		// TODO Auto-generated method stub
		return ddao.getSidoNames();
	}

	@Override
	public List<String> getGugunNames(String sidoName) throws SQLException {
		// TODO Auto-generated method stub
		return ddao.getGugunNames(sidoName);
	}

	@Override
	public List<Dong> getDongNames(Dong dong) throws SQLException {
		// TODO Auto-generated method stub
		return ddao.getDongNames(dong);
	}
	@Override
	public Dong select(String dongCode) throws SQLException {
		return ddao.select(dongCode);
	}

}
