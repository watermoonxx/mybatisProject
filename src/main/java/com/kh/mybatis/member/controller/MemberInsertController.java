package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member1;

@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String user_ID = request.getParameter("user_ID");
		String user_Pwd = request.getParameter("user_Pwd");
		String user_Name = request.getParameter("user_Name");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		/*
		 * String enroll_date = request.getParameter("enroll_date"); String modify_date
		 * = request.getParameter("modify_date"); String status =
		 * request.getParameter("status");
		 */
		
		Member1 m = new Member1(user_ID, user_Pwd, user_Name, email, birthday, gender, phone, address); // Member1 자바빈즈에 매개 변수 8개 생성자 새로 생성 
		
		int result = new MemberServiceImpl().insertMember(m); // 자바 빈 파일 넘겨줌 
		
		if (result > 0) { // 성공 (result == 1) 
			response.sendRedirect(request.getContextPath()); // 성공 시 메인 페이지로 이동 
		} else { // 실패 
			request.setAttribute("errorMsg", "회원가입 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
