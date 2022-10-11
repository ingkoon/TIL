package com.ssafy.interest.model.service;

import java.util.List;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.dao.InterestDao;
import com.ssafy.interest.model.dao.InterestDaoImpl;

public class InterestServiceImpl implements InterestService {
	private static InterestService interestService = new InterestServiceImpl();
	private InterestDao interestDao;
	
	private InterestServiceImpl() {
		interestDao = InterestDaoImpl.getInterestDao();
	}

	public static InterestService getInterestService() {
		return interestService;
	}
	@Override
	public List<InterestDto> getList(String user_id) throws Exception{
		return interestDao.getList(user_id);
	}

	@Override
	public int insert(InterestDto interestDto) throws Exception {
		return interestDao.insert(interestDto);
	}

	@Override
	public int delete(String user_id, String dongCode) throws Exception {
		return interestDao.delete(user_id, dongCode);
	}

}
