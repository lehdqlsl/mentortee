package com.mentotee.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.MagazinePurchaseVO;
import com.mentotee.app.vo.MagazineVO;

@Repository
public class CoinUseDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.CoinUseMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(CoinUseVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	public List<CoinUseVO> getHistory(int accounts_num) {
		return sqlSession.selectList(NAMESPACE + ".getHistory", accounts_num);
	}
}
