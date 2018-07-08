package com.mentotee.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.EventVO;
import com.mentotee.app.vo.MagazinePurchaseVO;
import com.mentotee.app.vo.MagazineVO;

@Repository
public class EventDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.EventMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(EventVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	public int update(EventVO vo) {
		return this.sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	public EventVO getInfo(int id) {
		return this.sqlSession.selectOne(NAMESPACE + ".getInfo", id);
	}
}
