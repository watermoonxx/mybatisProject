package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member1;

public class MemberDao {
	
	
	// MyBatis에서는 sqlSession 사용 
	
	
	// 호출해서 사용하기 위해 메소드 생성
	public int insertMember(SqlSession sqlSession, Member1 m) {
		int result = sqlSession.insert("memberMapper.insertMember", m);
		return result; 
	}
	
	// member-mapper.xml 파일 <mapper> 태그의 namespace 속성값과 <insert> 태그의 id 속성값  
	// <mapper namespace="memberMapper"> <insert id="insertMember"
	
	public Member1 loginMember(SqlSession sqlSession, Member1 m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
