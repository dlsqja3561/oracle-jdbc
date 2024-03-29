package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, createdate, updatedate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, createdate, updatedate"
				+ " 		FROM (SELECT board_no, board_title, createdate, updatedate"
				+ "					FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			b.setUpdatedate(rs.getString("updatedate"));
			list.add(b);
		}
		return list;
	}
	
	// lastPage
	public int selectMemberCount(Connection conn) throws Exception {
		int count = 0;
		String sql = "select COUNT(*) cnt from board";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt("cnt");
		}
		
		return count;
	}
	
	// BoardOne
	public Board selectBoardListOne(Connection conn, int boardNo) throws Exception {
		Board board = null;
		String sql = "SELECT board_title boardTitle, board_content boardContent, member_id memberId, createdate, updatedate"
				+ "		FROM board WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBoardTitle(rs.getString("boardTitle"));
			board.setBoardContent(rs.getString("boardContent"));
			board.setMemberId(rs.getString("memberId"));
			board.setCreatedate(rs.getString("createdate"));
			board.setUpdatedate(rs.getString("updatedate"));
		}
		
		return board;
	}
	
	// ModifyBoard
	public int modifyBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql = "UPDATE board SET board_title = ?, board_content = ?, updatedate = sysdate WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// AddBoard
	public int insertBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql = "INSERT INTO board (board_no, board_title, board_content, member_id, updatedate, createdate)"
				+ " VALUES (board_seq.nextval, ?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		row = stmt.executeUpdate();
		
		return row;
	}

	// RemoveBoard
	public int removeBoard(Connection conn, int boardNo) throws Exception {
		int row = 0;
		String sql = "DELETE FROM board WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		row = stmt.executeUpdate();
		
		return row;
	}


}
