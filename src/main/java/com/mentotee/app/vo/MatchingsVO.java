package com.mentotee.app.vo;

import java.sql.Date;

public class MatchingsVO
{
  private int matchings_num;
  private int mentor_id;
  private int mentee_id;
  private int state;
  private Date date_applied;
  private Date date_updated;
  private Date date_expire;
  private String t_remark;
  
  public MatchingsVO() {}
  
  public MatchingsVO(int matchings_num, int mentor_id, int mentee_id, int state, Date date_applied, Date date_updated, Date date_expire, String t_remark)
  {
    this.matchings_num = matchings_num;
    this.mentor_id = mentor_id;
    this.mentee_id = mentee_id;
    this.state = state;
    this.date_applied = date_applied;
    this.date_updated = date_updated;
    this.date_expire = date_expire;
    this.t_remark = t_remark;
  }
  
  public int getMatchings_num()
  {
    return this.matchings_num;
  }
  
  public void setMatchings_num(int matchings_num)
  {
    this.matchings_num = matchings_num;
  }
  
  public int getMentor_id()
  {
    return this.mentor_id;
  }
  
  public void setMentor_id(int mentor_id)
  {
    this.mentor_id = mentor_id;
  }
  
  public int getMentee_id()
  {
    return this.mentee_id;
  }
  
  public void setMentee_id(int mentee_id)
  {
    this.mentee_id = mentee_id;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int state)
  {
    this.state = state;
  }
  
  public Date getDate_applied()
  {
    return this.date_applied;
  }
  
  public void setDate_applied(Date date_applied)
  {
    this.date_applied = date_applied;
  }
  
  public Date getDate_updated()
  {
    return this.date_updated;
  }
  
  public void setDate_updated(Date date_updated)
  {
    this.date_updated = date_updated;
  }
  
  public Date getDate_expire()
  {
    return this.date_expire;
  }
  
  public void setDate_expire(Date date_expire)
  {
    this.date_expire = date_expire;
  }
  
  public String getT_remark()
  {
    return this.t_remark;
  }
  
  public void setT_remark(String t_remark)
  {
    this.t_remark = t_remark;
  }
}
