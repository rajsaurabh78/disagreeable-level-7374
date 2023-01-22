package com.modal;

public class everyBatchStudentDetails {
	private String sName;
	private int roll;
	private String sEmail;
	private String address;
	private String phone;
	private String bName;
	private int bId;
	private String cName;
	private int cId;
	
	public everyBatchStudentDetails() {
		// TODO Auto-generated constructor stub
	}

	public everyBatchStudentDetails(String sName, int roll, String sEmail, String address, String phone, String bName,
			int bId, String cName, int cId) {
		super();
		this.sName = sName;
		this.roll = roll;
		this.sEmail = sEmail;
		this.address = address;
		this.phone = phone;
		this.bName = bName;
		this.bId = bId;
		this.cName = cName;
		this.cId = cId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
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

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "everyBatchStudentDetails [sName=" + sName + ", roll=" + roll + ", sEmail=" + sEmail + ", address="
				+ address + ", phone=" + phone + ", bName=" + bName + ", bId=" + bId + ", cName=" + cName + ", cId="
				+ cId + "]";
	}
	
}
