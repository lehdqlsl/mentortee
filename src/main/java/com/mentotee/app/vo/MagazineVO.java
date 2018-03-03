package com.mentotee.app.vo;

public class MagazineVO {
	int b_num;
	int accounts_num;
	String title;
	String contents;
	boolean auth;
	String regdate;

	String email;

	public MagazineVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MagazineVO(int b_num, int accounts_num, String title, String contents, boolean auth, String regdate) {
		this.b_num = b_num;
		this.accounts_num = accounts_num;
		this.title = title;
		this.contents = contents;
		this.auth = auth;
		this.regdate = regdate;
	}
	
	public MagazineVO(int b_num, int accounts_num, String title, String contents, boolean auth, String regdate, String email) {
		this.b_num = b_num;
		this.accounts_num = accounts_num;
		this.title = title;
		this.contents = contents;
		this.auth = auth;
		this.regdate = regdate;
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
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

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
