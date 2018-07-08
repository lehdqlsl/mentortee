package com.mentotee.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.InquireVO;

@Repository
public class InquireDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.InquireMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(InquireVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}
}
