package com.hwj.pojo;

public class JobseekerInformation {
	private String name;
	private String sex;
	private String age;
	private String phone;
	private String major;
	private String salary;
	private String LoginID;

	public JobseekerInformation() {
		super();
	}

	public JobseekerInformation(String name, String sex, String age, String phone, String major, String salary,
			String loginID) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.major = major;
		this.salary = salary;
		LoginID = loginID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLoginID() {
		return LoginID;
	}

	public void setLoginID(String loginID) {
		LoginID = loginID;
	}

	@Override
	public String toString() {
		return "JobseekerInformation [name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", major="
				+ major + ", salary=" + salary + ", LoginID=" + LoginID + "]";
	}

}
