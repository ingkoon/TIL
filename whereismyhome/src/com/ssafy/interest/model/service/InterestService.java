package com.ssafy.interest.model.service;

import java.util.List;

import com.ssafy.interest.model.InterestDto;

public interface InterestService {
	List<InterestDto> getList(String user_id) throws Exception;
	int insert(InterestDto interestDto) throws Exception;
	int delete(String user_id, String dongCode)throws Exception;
}
