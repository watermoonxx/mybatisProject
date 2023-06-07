package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member1;

public interface MemberService {
	
	// 메소드 구현은 MyBatis가 할 것이고, 반환타입, 메소드, 매개변수만 명시 후 SQL과 연결시키면 된다 
	// 메소드가 구현되어 있는 곳은 MemberServiceImpl.java 
	
	int insertMember(Member1 m);
	
	Member1 loginMember(Member1 m);
	
	int updateMember(Member1 m);
	
	int deleteMember(String user_ID);
	
	
	
	

}
