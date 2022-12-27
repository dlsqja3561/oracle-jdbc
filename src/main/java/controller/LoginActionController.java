package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.MemberService;
import vo.Member;


@WebServlet("/LoginActionController")
public class LoginActionController extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		// 로그인 되어있으면 /BoardListController
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/BoardListController");
		}
		
		// loginForm에서 받아온 입력값
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println("memberId =" + memberId);
		System.out.println("memberPw =" + memberPw);
		
		Member paramMember = new Member(); 
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		Member returnMember = memberService.login(paramMember);
		
		if(returnMember == null) { // 로그인 실패
			System.out.println("로그인 실패 LoginActionController");
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		}
		
		// 로그인 성공시 session에 저장 Home으로
		session.setAttribute("loginMember", returnMember);
		response.sendRedirect(request.getContextPath()+"/BoardListController");
		
	}

}
