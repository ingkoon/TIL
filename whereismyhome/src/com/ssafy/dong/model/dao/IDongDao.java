package com.ssafy.dong.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dong.model.Dong;

public interface IDongDao {
	List<String> getSidoNames() throws SQLException;
	List<String> getGugunNames(String sidoName) throws SQLException;
	List<Dong> getDongNames(Dong dong) throws SQLException;
	Dong select(String dongCode) throws SQLException;
}
