package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 로그인 전
		 * 회원가입
		 * 로그인
		 * 
		 * 
		 * 로그인 후
		 * 로그아웃
		 * 회원정보
		 * 게시판리스트
		 * */
		
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			
		}
	}

}
