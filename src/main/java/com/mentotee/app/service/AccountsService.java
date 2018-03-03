package com.mentotee.app.service;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.vo.AccountsVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService
{
  @Autowired
  private AccountsDAO dao;
  
  public List<AccountsVO> getList()
  {
    return this.dao.getList();
  }
  
  public List<AccountsVO> getMentees()
  {
    return this.dao.getMentees();
  }
  
  public List<AccountsVO> getMentors()
  {
    return this.dao.getMentors();
  }
  
  public int insert(AccountsVO vo)
  {
    return this.dao.insert(vo);
  }
  
  public AccountsVO getInfo(String email)
  {
    return this.dao.getInfo(email);
  }
  
  public AccountsVO getInfo(int accounts_num)
  {
    return this.dao.getInfo(accounts_num);
  }
  
  public AccountsVO login(AccountsVO vo)
  {
    return this.dao.login(vo);
  }
  
  public int update(AccountsVO vo)
  {
    return this.dao.update(vo);
  }
  
  public int updateToken(AccountsVO vo)
  {
    return this.dao.updateToken(vo);
  }
}
