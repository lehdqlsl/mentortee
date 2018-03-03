package com.mentotee.app.vo;

import java.sql.Date;

public class AccountsVO
{
  private int accounts_num;
  private String email;
  private String password;
  private String name;
  private String hobby;
  private String wish;
  private String greeting;
  private int mentor;
  private int gender;
  private int job;
  private int carrer_years;
  private int state;
  private String birth;
  private Date requested;
  private Date updated;
  private Date accepted;
  private Date withdraw_request;
  private Date last_login;
  private Date coin_updated;
  private int coin;
  private String address;
  private String interest;
  private String career;
  private String token;
  
  public AccountsVO(int accounts_num, String email, String password, String name, String hobby, String wish, String greeting, int mentor, int gender, int job, int carrer_years, int state, String birth, Date requested, Date updated, Date accepted, Date withdraw_request, Date last_login, Date coin_updated, int coin, String address, String interest, String career, String token)
  {
    this.accounts_num = accounts_num;
    this.email = email;
    this.password = password;
    this.name = name;
    this.hobby = hobby;
    this.wish = wish;
    this.greeting = greeting;
    this.mentor = mentor;
    this.gender = gender;
    this.job = job;
    this.carrer_years = carrer_years;
    this.state = state;
    this.birth = birth;
    this.requested = requested;
    this.updated = updated;
    this.accepted = accepted;
    this.withdraw_request = withdraw_request;
    this.last_login = last_login;
    this.coin_updated = coin_updated;
    this.coin = coin;
    this.address = address;
    this.interest = interest;
    this.career = career;
    this.token = token;
  }
  
  public AccountsVO(int accounts_num, String hobby, String wish, String greeting, int job, int carrer_years, int state, Date requested, Date updated, Date accepted, Date withdraw_request, Date last_login, Date coin_updated, String address, String interest, String career, String token)
  {
    this.accounts_num = accounts_num;
    this.hobby = hobby;
    this.wish = wish;
    this.greeting = greeting;
    this.job = job;
    this.carrer_years = carrer_years;
    this.state = state;
    this.requested = requested;
    this.updated = updated;
    this.accepted = accepted;
    this.withdraw_request = withdraw_request;
    this.last_login = last_login;
    this.coin_updated = coin_updated;
    this.address = address;
    this.interest = interest;
    this.career = career;
    this.token = token;
  }
  
  public AccountsVO(String email, String password, String name, int mentor, int gender, String birth)
  {
    this.email = email;
    this.password = password;
    this.name = name;
    this.mentor = mentor;
    this.gender = gender;
    this.birth = birth;
  }
  
  public AccountsVO() {}
  
  public String getCareer()
  {
    return this.career;
  }
  
  public void setCareer(String career)
  {
    this.career = career;
  }
  
  public String getInterest()
  {
    return this.interest;
  }
  
  public void setInterest(String interest)
  {
    this.interest = interest;
  }
  
  public int getAccounts_num()
  {
    return this.accounts_num;
  }
  
  public void setAccounts_num(int accounts_num)
  {
    this.accounts_num = accounts_num;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getHobby()
  {
    return this.hobby;
  }
  
  public void setHobby(String hobby)
  {
    this.hobby = hobby;
  }
  
  public String getWish()
  {
    return this.wish;
  }
  
  public void setWish(String wish)
  {
    this.wish = wish;
  }
  
  public String getGreeting()
  {
    return this.greeting;
  }
  
  public void setGreeting(String greeting)
  {
    this.greeting = greeting;
  }
  
  public int getMentor()
  {
    return this.mentor;
  }
  
  public void setMentor(int mentor)
  {
    this.mentor = mentor;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public void setGender(int gender)
  {
    this.gender = gender;
  }
  
  public int getJob()
  {
    return this.job;
  }
  
  public void setJob(int job)
  {
    this.job = job;
  }
  
  public int getCarrer_years()
  {
    return this.carrer_years;
  }
  
  public void setCarrer_years(int carrer_years)
  {
    this.carrer_years = carrer_years;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int state)
  {
    this.state = state;
  }
  
  public String getBirth()
  {
    return this.birth;
  }
  
  public void setBirth(String birth)
  {
    this.birth = birth;
  }
  
  public Date getRequested()
  {
    return this.requested;
  }
  
  public void setRequested(Date requested)
  {
    this.requested = requested;
  }
  
  public Date getUpdated()
  {
    return this.updated;
  }
  
  public void setUpdated(Date updated)
  {
    this.updated = updated;
  }
  
  public Date getAccepted()
  {
    return this.accepted;
  }
  
  public void setAccepted(Date accepted)
  {
    this.accepted = accepted;
  }
  
  public Date getWithdraw_request()
  {
    return this.withdraw_request;
  }
  
  public void setWithdraw_request(Date withdraw_request)
  {
    this.withdraw_request = withdraw_request;
  }
  
  public Date getLast_login()
  {
    return this.last_login;
  }
  
  public void setLast_login(Date last_login)
  {
    this.last_login = last_login;
  }
  
  public Date getCoin_updated()
  {
    return this.coin_updated;
  }
  
  public void setCoin_updated(Date coin_updated)
  {
    this.coin_updated = coin_updated;
  }
  
  public int getCoin()
  {
    return this.coin;
  }
  
  public void setCoin(int coin)
  {
    this.coin = coin;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setToken(String token)
  {
    this.token = token;
  }
}
