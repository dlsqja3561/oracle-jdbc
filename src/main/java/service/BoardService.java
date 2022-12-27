package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;
import vo.Member;

public class BoardService {
	private BoardDao boardDao;
	
	public ArrayList<Board> getBoardListByPage(int currentPage, int rowPerPage) {
		/*
			1) connection 생성 <- DBUtil.class
			2) beginRow, endRow 생성 <- currentPage,rowPerPage를 가공
		*/
		ArrayList<Board> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			int beginRow = (currentPage-1) * rowPerPage + 1;
			int endRow = beginRow + rowPerPage -1;
			boardDao = new BoardDao();
			list = boardDao.selectBoardListByPage(conn, beginRow, endRow);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;	
	}
	
	public Board getBoardListOne(int boardNo) {
		Board board = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			board = boardDao.selectBoardListOne(conn, boardNo);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return board;
	}
	
	// insert
	public int getInsertBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			row = boardDao.insertBoard(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	
}
