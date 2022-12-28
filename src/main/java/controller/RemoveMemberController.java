package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;


@WebServlet("/member/removeMember")

public class RemoveMemberController extends HttpServlet {
	private MemberService memberService = null;
	// 회원 탈퇴 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//removeMember.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/removeMember.jsp").forward(request, response);
	}

	// 회원 탈퇴 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		String memberId = loginMember.getMemberId();
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId+", memberId ,RemoveMemberController");
		System.out.println(memberPw+", memberPw ,RemoveMemberController");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		row = memberService.getRemoveMember(member);
		
		if(row == 0) {
			System.out.println("삭제실패 RemoveMemberController");
		} else {
			System.out.println("삭제성공 RemoveMemberController");
			response.sendRedirect(request.getContextPath()+"/member/logout");
		}
	}

}
