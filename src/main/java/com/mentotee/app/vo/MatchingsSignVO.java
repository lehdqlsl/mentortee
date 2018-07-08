package com.mentotee.app.vo;

import java.sql.Date;

public class MatchingsSignVO {
	private int matchings_num;
	private int mentor_id;
	private int mentee_id;
	private Date date_applied;
	private Date date_expire;
	private String name;
	private String interest;
	private String hobby;

	public MatchingsSignVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MatchingsSignVO(int matchings_num, int mentor_id, int mentee_id, Date date_applied, Date date_expire,
			String name, String interest, String hobby) {
		super();
		this.matchings_num = matchings_num;
		this.mentor_id = mentor_id;
		this.mentee_id = mentee_id;
		this.date_applied = date_applied;
		this.date_expire = date_expire;
		this.name = name;
		this.interest = interest;
		this.hobby = hobby;
	}

	public int getMatchings_num() {
		return matchings_num;
	}

	public void setMatchings_num(int matchings_num) {
		this.matchings_num = matchings_num;
	}

	public int getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(int mentor_id) {
		this.mentor_id = mentor_id;
	}

	public int getMentee_id() {
		return mentee_id;
	}

	public void setMentee_id(int mentee_id) {
		this.mentee_id = mentee_id;
	}

	public Date getDate_applied() {
		return date_applied;
	}

	public void setDate_applied(Date date_applied) {
		this.date_applied = date_applied;
	}

	public Date getDate_expire() {
		return date_expire;
	}

	public void setDate_expire(Date date_expire) {
		this.date_expire = date_expire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
