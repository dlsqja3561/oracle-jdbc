package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;


@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	BoardService boardService = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		this.boardService = new BoardService();
		row = boardService.getRemoveBoard(boardNo);
		
		if(row == 0) {
			System.out.println("삭제실패 RemoveBoardController");
		} else {
			System.out.println("삭제성공 RemoveBoardController");
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		}
	}

}
