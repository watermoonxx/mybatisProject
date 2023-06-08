package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;

@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService bSer = new BoardServiceImpl();
		
		// 조회수 올려주기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		// int result = new BoardServiceImpl().increaseCount(boardNo);
		int result = bSer.increaseCount(boardNo);
		
		// 해당 게시글의 boardNo을 받아서 DB 조회
		if (result > 0) {
			// Board b = new BoardServiceImpl().selectBoard(boardNo);
			Board b = bSer.selectBoard(boardNo);
		
		
			// 댓글 조회
			// ArrayList로 boardNo에 해당하는 댓글 모두 조회하여
			ArrayList<Reply> list = bSer.selectReplyList(boardNo);
				
			
			// request에 담아서 전달
			request.setAttribute("b", b);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
			
		}
	}

}
