package com.modal;

public class Student {
	private int roll;
	private String sName;
	private String sEmail;
	private String sPassword;
	private String address;
	private String phone;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", sName=" + sName + ", sEmail=" + sEmail + ", sPassword=" + sPassword
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(int roll, String sName, String sEmail, String sPassword, String address, String phone, int cId) {
		super();
		this.roll = roll;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
		this.address = address;
		this.phone = phone;

	}
}
