package com.mentotee.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mentotee.app.vo.MagazineVO;

@Repository
public class MagazineDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mentotee.mybatis.MagazineMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(MagazineVO vo) {
		return this.sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	public List<MagazineVO> getList() {
		return sqlSession.selectList(NAMESPACE + ".getList");
	}

	public List<MagazineVO> getNoList() {
		return sqlSession.selectList(NAMESPACE + ".getNoList");
	}

	public int setAuth(String b_num) {
		return sqlSession.update(NAMESPACE + ".setAuth", b_num);
	}

	public MagazineVO getMagazine(String b_num) {
		return sqlSession.selectOne(NAMESPACE + ".getMagazine", b_num);
	}
}
