package com.ssafy.board.model.mapper;

import com.ssafy.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface BoardMapper {
    void writeArticle(BoardDto board) throws SQLException;
    BoardDto getArticle(int articleNo) throws SQLException;
    List<BoardDto> listArticle(Map<String, Objects> map) throws SQLException;
}
