package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;
import vo.Member;

public class MemberDao {

	// admin - MemberList
	public ArrayList<Member> selectMemberListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select t2.rnum rnum, t2.memberId memberId t2.memberName memberName, t2.memberLevel memberLevel, t2.updatedate updatedate, t2.createdate createdate"
				+ " from (select rownum rnum, t.member_id memberId t.member_name memberName, t.member_level memberLevel, t.updatedate updatedate, t.createdate createdate"
				+ " 	from (select member_id member_name, member_level, updatedate, createdate"
				+ " 		from member order by member_name asc) t) t2"
				+ " where rnum between ? and ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		/*
			page	beginRow	endRow
			1		1			10
			2		11			20
			3		21			30
		*/
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Member m = new Member();
			m.setRowNum(rs.getInt("rnum"));
			m.setMemberId(rs.getString("memberId"));
			m.setMemberName(rs.getString("memberName"));
			m.setMemberLevel(rs.getString("memberLevel"));
			m.setUpdatedate(rs.getString("updatedate"));
			m.setCreatedate(rs.getString("createdate"));
			list.add(m);
		}
		return list;
	}
	
	// admin - modifyMemberLevel
	public int modifyMemberLevel(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "UPDATE member SET member_level = ?, updatedate = sysdate WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberLevel());
		stmt.setString(2, member.getMemberId());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// admin - removeMember
	public int adminRemoveMember(Connection conn, String memberId) throws Exception {
		int row = 0;
		String sql = "DELETE FROM member WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 로그인 메서드
	public Member selectMemberByIdAndPw(Connection conn, Member paramMember) throws Exception {
		Member resultMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String spl = "SELECT member_id memberId, member_name memberName, member_level memberLevel FROM member WHERE member_id = ? AND member_pw = ?";
		
		stmt = conn.prepareStatement(spl);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
			resultMember.setMemberLevel(rs.getString("memberLevel"));
		}
		
		return resultMember;
	}
		
	
	// memberOne
	public Member selectMemberOne(Connection conn, String memberId) throws Exception {
		Member member = null;
		String sql = "SELECT member_name memberName, createdate, updatedate"
				+ "		FROM member WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			member = new Member();
			member.setMemberName(rs.getString("memberName"));
			member.setCreatedate(rs.getString("createdate"));
			member.setUpdatedate(rs.getString("updatedate"));
			
		}
		return member;
	}
	
	// modifyMember
	public int modifyMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "UPDATE member SET member_name = ?, updatedate = sysdate WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberName());
		stmt.setString(2, member.getMemberId());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// addMember
	public int addMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "INSERT INTO member (member_id, member_pw, member_name, createdate, updatedate)"
				+ " VALUES (?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// removeMember
	public int removeMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "DELETE FROM member WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	
	
}
