package com.mentotee.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.CoinPurchaseVO;

@Repository
public class CoinPurchaseDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.CoinPurchaseMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(CoinPurchaseVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	public List<CoinPurchaseVO> getHistory(int accounts_num) {
		return sqlSession.selectList(NAMESPACE + ".getHistory", accounts_num);
	}
}
