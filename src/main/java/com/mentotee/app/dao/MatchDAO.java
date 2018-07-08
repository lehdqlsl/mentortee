package com.mentotee.app.dao;

import com.mentotee.app.vo.MatchingsSignVO;
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
  
  public List<MatchingsSignVO> getMatchingMentees(int mentor_id)
  {
    return this.sqlSession.selectList(NAMESPACE+".getMatchingMentees", mentor_id);
  }
  
  public List<MatchingsSignVO> getMatchingMentors(int mentee_id)
  {
    return this.sqlSession.selectList(NAMESPACE+".getMatchingMentors", mentee_id);
  }
  
  public int setRenewal(int matchings_num) {
	  return this.sqlSession.update("com.mentotee.mybatis.MatchingsMapper.setRenewal", matchings_num);
  }
  
  public List<MatchingsVO> isExpire()
  {
	  return this.sqlSession.selectList(NAMESPACE+".isExpire");
  }
  
  public int setState(MatchingsVO vo) {
	  return this.sqlSession.update(NAMESPACE+".setState",vo);
  }
}
