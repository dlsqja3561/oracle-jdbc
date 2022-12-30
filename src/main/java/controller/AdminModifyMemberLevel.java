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


@WebServlet("/admin/modifyMemberLevel")
public class AdminModifyMemberLevel extends HttpServlet {
	private MemberService memberService;
	// admin memberLevel 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberLevel = loginMember.getMemberLevel();
		if(loginMember == null || memberLevel.equals("일반")) { // 일반멤버이면 /loginController
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		String memberId = request.getParameter("memberId");
		request.setAttribute("memberId", memberId);
		
		// modifyMember.jsp
		request.getRequestDispatcher("/WEB-INF/view/admin/modifyMemberLevel.jsp").forward(request, response);
	}

	// admin memberLevel 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		int row = 0;
		String memberId = request.getParameter("memberId");
		String memberLevel = request.getParameter("memberLevel");
		System.out.println(memberId  + ", memberId ,AdminModifyMemberController");
		System.out.println(memberLevel  + ", memberLevel ,AdminModifyMemberController");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberLevel(memberLevel);
		
		this.memberService = new MemberService();
		row = memberService.getModifyMemberLevel(member);
		
		if(row == 0) {
			System.out.println("수정실패, AdminModifyMemberController");
		} else {
			System.out.println("수정성공, AdminModifyMemberController");
			response.sendRedirect(request.getContextPath()+"/admin/memberList");
		}
	}

}
