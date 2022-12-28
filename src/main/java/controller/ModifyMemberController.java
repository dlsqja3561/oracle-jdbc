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


@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원정보 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		// modifyMember.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMember.jsp").forward(request, response);
	}

	// 회원정보 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		
		String memberName = request.getParameter("memberName");
		System.out.println(memberName  + ", memberName ,ModifyMemberController");
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		System.out.println(memberId+", memberId ,ModifyMemberController");
		
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberId(memberId);
		
		memberService = new MemberService();
		int row = memberService.getModifyMember(member);
		
		if(row == 0) {
			System.out.println("수정실패, ModifyMemberController");
		} else {
			System.out.println("수정성공, ModifyMemberController");
			response.sendRedirect(request.getContextPath()+"/home");
		}
	}

}
