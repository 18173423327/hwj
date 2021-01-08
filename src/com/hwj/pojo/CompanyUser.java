package com.hwj.pojo;

public class CompanyUser {
	private String LoginID;
	private String Password;

	public CompanyUser() {
		super();
	}

	public CompanyUser(String loginID, String password) {
		super();
		LoginID = loginID;
		Password = password;
	}

	public String getLoginID() {
		return LoginID;
	}

	public void setLoginID(String loginID) {
		LoginID = loginID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "CompanyUser [LoginID=" + LoginID + ", Password=" + Password + "]";
	}
}
