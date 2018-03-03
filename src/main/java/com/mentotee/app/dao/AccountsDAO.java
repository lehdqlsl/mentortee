package com.mentotee.app.dao;

import com.mentotee.app.vo.AccountsVO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsDAO
{
  @Autowired
  private SqlSession sqlSession;
  private final String NAMESPACE = "com.mentotee.mybatis.AccountsMapper";
  
  public void setSqlSession(SqlSession sqlSession)
  {
    this.sqlSession = sqlSession;
  }
  
  public List<AccountsVO> getList()
  {
    return this.sqlSession.selectList("com.mentotee.mybatis.AccountsMapper.getList");
  }
  
  public List<AccountsVO> getMentees()
  {
    return this.sqlSession.selectList("com.mentotee.mybatis.AccountsMapper.getMentees");
  }
  
  public List<AccountsVO> getMentors()
  {
    return this.sqlSession.selectList("com.mentotee.mybatis.AccountsMapper.getMentors");
  }
  
  public int insert(AccountsVO vo)
  {
    BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
    String pwd = vo.getPassword();
    vo.setPassword(bcr.encode(pwd));
    return this.sqlSession.insert("com.mentotee.mybatis.AccountsMapper.insert", vo);
  }
  
  public AccountsVO getInfo(String email)
  {
    return (AccountsVO)this.sqlSession.selectOne("com.mentotee.mybatis.AccountsMapper.getInfo", email);
  }
  
  public AccountsVO getInfo(int accounts_num)
  {
    return (AccountsVO)this.sqlSession.selectOne("com.mentotee.mybatis.AccountsMapper.getInfo1", Integer.valueOf(accounts_num));
  }
  
  public AccountsVO login(AccountsVO vo)
  {
    return (AccountsVO)this.sqlSession.selectOne("com.mentotee.mybatis.AccountsMapper.login", vo);
  }
  
  public int update(AccountsVO vo)
  {
    return this.sqlSession.update("com.mentotee.mybatis.AccountsMapper.update", vo);
  }
  
  public int updateToken(AccountsVO vo)
  {
    return this.sqlSession.update("com.mentotee.mybatis.AccountsMapper.updateToken", vo);
  }
}
