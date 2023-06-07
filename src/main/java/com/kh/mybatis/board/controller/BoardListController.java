package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totalRecord = new BoardServiceImpl().selectTotalRecord();
		
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		PageInfo pi = Pagination.getPageInfo(totalRecord, nowPage, 5, 3);
		
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		request.setAttribute("pi", pi); 
		request.setAttribute("list", list); // ArrayList로 반환된 list 
		
		// request.setAttribute("count", listCount);
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
		
	}

}
