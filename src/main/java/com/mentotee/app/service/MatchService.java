package com.mentotee.app.service;

import com.mentotee.app.dao.MatchDAO;
import com.mentotee.app.vo.MatchingsVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService
{
  @Autowired
  private MatchDAO dao;
  
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
  
  public int update(MatchingsVO vo)
  {
    return this.dao.update(vo);
  }
}
