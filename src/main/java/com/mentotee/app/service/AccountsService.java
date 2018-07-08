package com.mentotee.app.service;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.dao.EventDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.EventVO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountsService
{
  @Autowired
  private AccountsDAO dao;
  
  @Autowired
  private EventDAO event_dao;
  
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
  
  @Transactional
  public int update(AccountsVO vo)
  {
	int n = event_dao.insert(new EventVO(vo.getAccounts_num(), null, 0));
	n = this.dao.update(vo);
    return n;
  }
  
  public int updateToken(AccountsVO vo)
  {
    return this.dao.updateToken(vo);
  }
  
  public int updateCoin(AccountsVO vo) {
	  return this.dao.update(vo);
  }
}
