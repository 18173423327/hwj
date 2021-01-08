package com.hwj.pojo;

public class JobseekerUser {
	private String LoginID;
	private String Password;

	public JobseekerUser() {
		super();
	}

	public JobseekerUser(String loginID, String password) {
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
		return "JobseekerUser [LoginID=" + LoginID + ", Password=" + Password + "]";
	}

}
