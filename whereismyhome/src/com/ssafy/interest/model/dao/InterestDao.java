package com.ssafy.interest.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.interest.model.InterestDto;

public interface InterestDao {
	List<InterestDto> getList(String user_id) throws SQLException;
	int insert(InterestDto interestDto) throws SQLException;
	int delete(String user_id, String dongCode)throws SQLException;
}
