package com.mentotee.app.vo;

import java.sql.Date;

public class EventVO {
	int accounts_id;
	Date reg_date;
	int today_id;
	
	public EventVO() {
		
	}

	public EventVO(int accounts_id, Date reg_date, int today_id) {
		super();
		this.accounts_id = accounts_id;
		this.reg_date = reg_date;
		this.today_id = today_id;
	}
	
	public int getAccounts_id() {
		return accounts_id;
	}

	public void setAccounts_id(int accounts_id) {
		this.accounts_id = accounts_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getToday_id() {
		return today_id;
	}

	public void setToday_id(int today_id) {
		this.today_id = today_id;
	}
	
	
}
