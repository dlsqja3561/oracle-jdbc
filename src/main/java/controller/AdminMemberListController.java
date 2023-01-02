package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;


@WebServlet("/admin/memberList")
public class AdminMemberListController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) { // 일반멤버이면 /loginController
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberLevel = loginMember.getMemberLevel();
		if(memberLevel.equals("일반")) {
			response.sendRedirect(request.getContextPath()+"/member/home");
			return;
		}
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		this.memberService = new MemberService();
		ArrayList<Member> list = memberService.getMemberListByPage(currentPage, rowPerPage);
		// lastPage
		int count = memberService.getMemberLastPage();
		int lastPage = count / rowPerPage;
		if(count % rowPerPage != 0) {
			lastPage += 1;
		}
		
		request.setAttribute("memberList", list);
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/memberList.jsp").forward(request, response);
		
	}

}
