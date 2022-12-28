package service;

import java.sql.Connection;

import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	// login
	public Member login(Member paramMember) {
		memberDao = new MemberDao();
		Member resultMember = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			resultMember = memberDao.selectMemberByIdAndPw(conn, paramMember);
			conn.commit();
		} catch(Exception e) {
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
		
		return resultMember;
	}
	
	// memberOneController
	public Member memberOne(String memberId) {
		memberDao = new MemberDao();
		Member member = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			member = memberDao.selectMemberOne(conn, memberId);
			conn.commit();
		} catch(Exception e) {
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
		return member;
	}
	
	// modifyMemberController
	public int getModifyMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			row = memberDao.modifyMember(conn, member);
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
	
	// AddMemberController
	public int getAddMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			row = memberDao.addMember(conn, member);
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
	
	// removeMemberController
	public int getRemoveMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			row = memberDao.removeMember(conn, member);
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
