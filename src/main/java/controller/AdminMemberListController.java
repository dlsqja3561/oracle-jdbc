package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;


@WebServlet("/admin/memberList")
public class AdminMemberListController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) controller
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
		request.setAttribute("memberList", list);
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("rowPerPage", rowPerPage);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/memberList.jsp").forward(request, response);
		
	}

}
