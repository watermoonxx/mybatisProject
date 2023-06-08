package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	// 게시판에 있는 게시물의 총 개수부터 얻어오기 
	public int selectTotalRecord(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectTotalRecord");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// 마이바티스에서 페이징처리를 위해 RowBounds라는 클래스를 제공해준다 
		// (Ref. MyBatis 공식문서 'rowbounds' 검색)
		
		/*
			ex. numPerPage -> 5
			
										offset(건너뛸 숫자)	limit(조회할 숫자 개수) 
			nowPage -> [1]		1~5				0				5개
			nowPage -> [2]		6~10			5				5개
			nowPage -> [3]		11~15			10				5개
		 */
		
		int limit = pi.getNumPerPage();
		int offset = (pi.getNowPage()-1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit); // 공식문서 
		
		ArrayList<Board> list = (ArrayList) sqlSession.selectList("boardMapper.selectList", null, rowBounds);
								// Object 타입을 ArrayList로 형변환 
		return list;
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper", map);
	}

}
