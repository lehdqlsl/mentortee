package com.mentotee.app.service;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.dao.CoinUseDAO;
import com.mentotee.app.dao.MatchDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.MatchingsSignVO;
import com.mentotee.app.vo.MatchingsVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchService
{
  @Autowired
  private MatchDAO dao;
  
  @Autowired
  private AccountsDAO a_dao;
  
  @Autowired
  private CoinUseDAO coin_dao;
  
  public int insert(MatchingsVO vo)
  {
    return this.dao.insert(vo);
  }
  
  public List<MatchingsVO> getMenteeList(int id)
  {
    return this.dao.getMenteeList(id);
  }
  
  public List<MatchingsVO> getMentorList(int id)
  {
    return this.dao.getMentorList(id);
  }
  
  @Transactional
  public int update(MatchingsVO vo, AccountsVO mentee, AccountsVO mentor)
  {
	int n = dao.update(vo);
	mentee.setCoin(mentee.getCoin()-500);
	mentor.setCoin(mentor.getCoin()-500);
	n = a_dao.updateCoin(mentee);
	n = a_dao.updateCoin(mentor);
	return n;
  }
  
  public List<MatchingsSignVO> getMatchingMentees(int mentor_id)
  {
    return dao.getMatchingMentees(mentor_id);
  }
  
  public List<MatchingsSignVO> getMatchingMentors(int mentee_id)
  {
    return dao.getMatchingMentors(mentee_id);
  }
  
  @Transactional
  public int setRenewal(int matchings_num, AccountsVO vo) {
	  int n= dao.setRenewal(matchings_num);
	  vo.setCoin(vo.getCoin()-650);
	  n = a_dao.updateCoin(vo);
	  n = coin_dao.insert(new CoinUseVO(0, vo.getAccounts_num(), 650, null,1));
	  
	  return n;
  }
  
  public List<MatchingsVO> isExpire(){
	  return dao.isExpire();
  }
  
  public int setState(MatchingsVO vo) {
	  return dao.setState(vo);
  }
}
