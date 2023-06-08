package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		
		BoardServiceImpl bSerImpl = new BoardServiceImpl();
		int searchCount =  bSerImpl.selectSearchCount(map);
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		PageInfo pi =  Pagination.getPageInfo(searchCount, nowPage, 5, 3);
		
		ArrayList<Board> list = bSerImpl.selectSearchList(map, pi);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
