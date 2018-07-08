package com.mentotee.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.MagazinePurchaseVO;
import com.mentotee.app.vo.MagazineVO;

@Repository
public class MagazinePurchaseDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.MagazinePurchaseMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(MagazinePurchaseVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	public MagazinePurchaseVO getHistory(MagazinePurchaseVO vo) {
		return sqlSession.selectOne(NAMESPACE + ".getHistory", vo);
	}
}
