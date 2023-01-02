package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;


@WebServlet("/admin/removeMember")
public class AdminRemoveMemberController extends HttpServlet {
	private MemberService memberService = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+", memberId ,AdminRemoveMemberController");
		
		this.memberService = new MemberService();
		row = memberService.getAdminRemoveMember(memberId);
		
		if(row == 0) {
			System.out.println("삭제실패 RemoveMemberController");
		} else {
			System.out.println("삭제성공 RemoveMemberController");
			response.sendRedirect(request.getContextPath()+"/admin/memberList");
		}
	}

}
