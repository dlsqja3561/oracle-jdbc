package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	// 로그인 메서드
	public Member selectMemberByIdAndPw(Connection conn, Member paramMember) throws Exception {
		Member resultMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String spl = "SELECT member_id memberId, member_name memberName FROM member WHERE member_id = ? AND member_pw = ?";
		
		stmt = conn.prepareStatement(spl);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
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
