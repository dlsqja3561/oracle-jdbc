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


@WebServlet("/board/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	BoardService boardService = null;
	// 글 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안되어있으면 /loginController
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo  + "boardNo ,ModifyBoardController");
		
		Board board = new Board();
		boardService = new BoardService();
		board = boardService.getBoardListOne(boardNo);
		
		request.setAttribute("board", board);
		request.setAttribute("boardNo", boardNo);
		request.getRequestDispatcher("/WEB-INF/view/board/modifyBoard.jsp").forward(request, response);
	}

	// 글 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(title  + ", title ,ModifyBoardController");
		System.out.println(content  + ", content ,ModifyBoardController");
		System.out.println(boardNo  + ", boardNo ,ModifyBoardController");
		
		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setBoardNo(boardNo);
		
		boardService = new BoardService();
		int row = boardService.getModifyBoard(board);
		
		if(row == 0) {
			System.out.println("수정실패, ModifyBoardController");
		} else {
			System.out.println("수정성공, ModifyBoardController");
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		}
		
	}

}
