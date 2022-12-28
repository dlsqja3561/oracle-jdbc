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


@WebServlet("/member/memberOne")
public class MemberOneContoller extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		System.out.println(memberId+", memberId,MemberOneContoller");
		
		Member member = new Member();
		memberService = new MemberService();
		member = memberService.memberOne(memberId);
		
		request.setAttribute("member", member);
		request.setAttribute("memberId", memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/member/memberOne.jsp").forward(request, response);
		
	}

}
