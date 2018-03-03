package com.mentotee.app.dao;

import com.mentotee.app.vo.MatchingsVO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDAO
{
  @Autowired
  private SqlSession sqlSession;
  private final String NAMESPACE = "com.mentotee.mybatis.MatchingsMapper";
  
  public void setSqlSession(SqlSession sqlSession)
  {
    this.sqlSession = sqlSession;
  }
  
  public int insert(MatchingsVO vo)
  {
    return this.sqlSession.insert("com.mentotee.mybatis.MatchingsMapper.insert", vo);
  }
  
  public List<MatchingsVO> getMenteeList(int id)
  {
    return this.sqlSession.selectList("com.mentotee.mybatis.MatchingsMapper.getMenteeList", Integer.valueOf(id));
  }
  
  public List<MatchingsVO> getMentorList(int id)
  {
    return this.sqlSession.selectList("com.mentotee.mybatis.MatchingsMapper.getMentorList", Integer.valueOf(id));
  }
  
  public int update(MatchingsVO vo)
  {
    return this.sqlSession.update("com.mentotee.mybatis.MatchingsMapper.update", vo);
  }
}
