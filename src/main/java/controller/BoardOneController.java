package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;


@WebServlet("/board/boardOne")
public class BoardOneController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Member loginMember = (Member)session.getAttribute("loginMember");
		String loginId = loginMember.getMemberId();
		
		Board board = new Board();
		
		this.boardService = new BoardService();
		board = boardService.getBoardListOne(boardNo);
		
		request.setAttribute("board", board);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("loginId", loginId);
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp").forward(request, response);
	}

}
