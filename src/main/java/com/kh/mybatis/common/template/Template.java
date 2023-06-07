package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession; // ibatis -> mybatis 이전에 사용 
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		// String resource = "../resources/mybatis-config.xml";
		String resource = "/mybatis-config.xml";
		
		// SqlSession을 생성하기 위해서는 SqlSessionFactory 필요
		// SqlSessionFactory -> SqlSessionFactoryBuilder 필요 
		
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); // false -> 수동 커밋
			// SQL 세션 만들어짐 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
