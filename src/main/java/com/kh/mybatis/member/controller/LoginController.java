package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member1;

@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member1 m = new Member1();
		m.setUser_ID(request.getParameter("user_ID"));
		m.setUser_Pwd(request.getParameter("user_Pwd"));
		
		Member1 loginUser = new MemberServiceImpl().loginMember(m);
		
		if (loginUser == null) { // 로그인 실패 시 
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
		} else { // 로그인 성공 시 
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
		}
	}

}
