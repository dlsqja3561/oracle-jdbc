package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	
	// 글쓰기 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// addBoardForm.jsp
		request.getRequestDispatcher("/WEB-INF/view/board/addBoardForm.jsp").forward(request, response);
	}

	// 글쓰기 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		System.out.println("boardTitle"+boardTitle);
		System.out.println("boardContent"+boardContent);
		String memberId = "goodee";
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		
		this.boardService = new BoardService();
		int row = boardService.getInsertBoard(board);
		
		if(row == 0) {
			System.out.println("글쓰기 실패, AddBoardController");
		}
		System.out.println("글쓰기 성공, AddBoardController");
		response.sendRedirect(request.getContextPath()+"/board/boardList");
	}

}
