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


@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 되어있으면 /home
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		//login.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		// 로그인 되어있으면 /home
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		// login.jsp에서 받아온 입력값
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
			System.out.println("로그인 실패 LoginController");
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		// 로그인 성공시 session에 저장 Home으로
		System.out.println("로그인 성공 LoginController");
		session.setAttribute("loginMember", returnMember);
		response.sendRedirect(request.getContextPath()+"/home");
	}

}
