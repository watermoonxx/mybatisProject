package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member1;

public class MemberServiceImpl implements MemberService {
	// 인터페이스 구현 클래스 

	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member1 m) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = mDao.insertMember(sqlSession, m);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return 0;
	}

	@Override
	public Member1 loginMember(Member1 m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member1 loginUser = mDao.loginMember(sqlSession, m); // ID, Pwd 들어있는 자바 빈 객체를 넘겨줌 
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member1 m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String user_ID) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
