package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		// 로그인 되어있으면
		Member loginMember = (Member)session.getAttribute("loginMember");
		request.setAttribute("loginMember", loginMember);
		
		// home.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/home.jsp").forward(request, response);
	}
}
