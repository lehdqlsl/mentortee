package com.mentotee.app.vo;

import java.sql.Date;

public class InquireVO {
	private int i_num;
	private int accounts_num;
	private String title;
	private String contents;
	private int type;
	private Date regdate;
	
	public InquireVO(int i_num, int accounts_num, String title, String contents, int type, Date regdate) {
		super();
		this.i_num = i_num;
		this.accounts_num = accounts_num;
		this.title = title;
		this.contents = contents;
		this.type = type;
		this.regdate = regdate;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public int getAccounts_num() {
		return accounts_num;
	}
	public void setAccounts_num(int accounts_num) {
		this.accounts_num = accounts_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
