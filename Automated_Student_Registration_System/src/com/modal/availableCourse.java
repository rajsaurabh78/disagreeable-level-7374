package com.modal;

public class availableCourse {
	private int cId;
	private String cName;
	private String bName;
	private String seats;
	public availableCourse() {
		// TODO Auto-generated constructor stub
	}
	public availableCourse(int cId, String cName, String bName, String seats) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.bName = bName;
		this.seats = seats;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "availableCourse [cId=" + cId + ", cName=" + cName + ", bName=" + bName + ", seats=" + seats + "]";
	}
	

}
