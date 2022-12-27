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
}
