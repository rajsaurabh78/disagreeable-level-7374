package com.modal;

public class Batch {
	private String bName;
	private int cId;
	private int seats;
	private int roll;
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	public Batch(String bName, int cId, int seats, int roll) {
		super();
		this.bName = bName;
		this.cId = cId;
		this.seats = seats;
		this.roll = roll;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Batch [bName=" + bName + ", cId=" + cId + ", seats=" + seats + ", roll=" + roll + "]";
	}
	
}