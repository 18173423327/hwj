package com.hwj.pojo;

public class CompanyInformation {
	private String name;
	private String major;
	private String salary;
	private String num;
	private String address;

	public CompanyInformation() {
		super();
	}

	public CompanyInformation(String name, String major, String salary, String num, String address) {
		super();
		this.name = name;
		this.major = major;
		this.salary = salary;
		this.num = num;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CompanyInformation [name=" + name + ", major=" + major + ", salary=" + salary + ", num=" + num
				+ ", address=" + address + "]";
	}

}
