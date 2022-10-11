package com.ssafy.dong.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dong.model.Dong;

public interface IDongService {
	List<String> getSidoNames() throws SQLException;
	List<String> getGugunNames(String sidoName) throws SQLException;
	List<Dong> getDongNames(Dong dong) throws SQLException;
	Dong select(String dongCode) throws SQLException;
}
