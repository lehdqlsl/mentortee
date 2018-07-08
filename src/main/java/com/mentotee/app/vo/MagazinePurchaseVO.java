package com.mentotee.app.vo;

import java.sql.Date;

public class MagazinePurchaseVO {
	int seq;
	int accounts_num;
	int b_num;
	private Date reg_date;
		
	public MagazinePurchaseVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MagazinePurchaseVO(int seq, int accounts_num, int b_num, Date reg_date) {
		super();
		this.seq = seq;
		this.accounts_num = accounts_num;
		this.b_num = b_num;
		this.reg_date = reg_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getAccounts_num() {
		return accounts_num;
	}
	public void setAccounts_num(int accounts_num) {
		this.accounts_num = accounts_num;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	
}
	

