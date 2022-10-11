package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();
	private DBUtil dbUtil;

	private BoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static BoardDao getBoardDao() {
		return boardDao;
	}

	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into board(user_id, subject, content, hit, register_time) \n");
			sql.append(" values(?,?,?,0,now()) ");
			psmt = conn.prepareStatement(sql.toString());

			int i = 1;
			psmt.setString(i++, boardDto.getUserId());
			psmt.setString(i++, boardDto.getSubject());
			psmt.setString(i++, boardDto.getContent());

			cnt = psmt.executeUpdate();
		} finally {
			dbUtil.close(psmt, conn);
		}

		return cnt;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws SQLException {
		List<BoardDto> list = new ArrayList<BoardDto>();

		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select article_no,user_id,subject,content,hit,register_time \n");
			sql.append(" from board \n");
			String key = map.get("key");
			String word = map.get("word");
			if (!word.isEmpty()) {
				if (key.equals("subject")) {
					sql.append(" where subject like ?  \n");
				} else {
					sql.append(" where user_id =? \n");
				}
			}
			sql.append(" order by article_no desc limit ?,?");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 1;
			if (!word.isEmpty()) {
				if (key.equals("subject")) {
					pstmt.setString(i++, "%" + word + "%");
				} else {
					pstmt.setString(i++, word);
				}
			}
			pstmt.setInt(i++, Integer.parseInt(map.get("start")));
			pstmt.setInt(i++, Integer.parseInt(map.get("spl")));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));

				list.add(boardDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public int totalArticleCount(Map<String, String> map) throws SQLException {
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		BoardDto boardDto= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select article_no,user_id,subject,content,hit,register_time \n");
			sql.append(" from board \n");
			sql.append(" where article_no=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return boardDto;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" update board \n");
			sql.append(" set hit = hit +1 \n");
			sql.append(" where article_no = ? ");
			psmt = conn.prepareStatement(sql.toString());

			int i = 1;
			psmt.setInt(i++, articleNo);

			psmt.executeUpdate();
		} finally {
			dbUtil.close(psmt, conn);
		}
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" update board \n");
			sql.append(" set subject = ?, content=? \n");
			sql.append(" where article_no = ? ");
			psmt = conn.prepareStatement(sql.toString());

			int i = 1;
			psmt.setString(i++, boardDto.getSubject());
			psmt.setString(i++, boardDto.getContent());
			psmt.setInt(i++, boardDto.getArticleNo());

			psmt.executeUpdate();
		} finally {
			dbUtil.close(psmt, conn);
		}
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" delete from  board \n");
			sql.append(" where article_no = ? ");
			psmt = conn.prepareStatement(sql.toString());

			int i = 1;
			psmt.setInt(i++, articleNo);

			psmt.executeUpdate();
		} finally {
			dbUtil.close(psmt, conn);
		}
	}

}
