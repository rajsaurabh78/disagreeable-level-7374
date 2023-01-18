package com.modal;

public class Course {
	private int cId;
	private String cName;
	private String duration;
	private int fee;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(int cId, String cName, String duration, int fee) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.duration = duration;
		this.fee = fee;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", duration=" + duration + ", fee=" + fee + "]";
	}
	
}
