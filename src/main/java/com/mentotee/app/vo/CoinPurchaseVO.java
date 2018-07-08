package com.mentotee.app.vo;

import java.sql.Date;

public class CoinPurchaseVO {
	int seq;
	int accounts_num;
	int coin;
	private Date reg_date;
	
	public CoinPurchaseVO(int seq, int accounts_num, int coin, Date reg_date) {
		super();
		this.seq = seq;
		this.accounts_num = accounts_num;
		this.coin = coin;
		this.reg_date = reg_date;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public CoinPurchaseVO() {
		// TODO Auto-generated constructor stub
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

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	
	
}
