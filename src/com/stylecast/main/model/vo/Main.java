package com.stylecast.main.model.vo;

public class Main {
	
	private int dailyNo;
	private String dailyImg;
	
	public Main() {}

	
	
	public Main(int dailyNo, String dailyImg) {
		super();
		this.dailyNo = dailyNo;
		this.dailyImg = dailyImg;
	}



	public int getDailyNo() {
		return dailyNo;
	}



	public void setDailyNo(int dailyNo) {
		this.dailyNo = dailyNo;
	}



	public String getDailyImg() {
		return dailyImg;
	}



	public void setDailyImg(String dailyImg) {
		this.dailyImg = dailyImg;
	}



	@Override
	public String toString() {
		return "Main [dailyNo=" + dailyNo + ", dailyImg=" + dailyImg + "]";
	}
	
	
	
}
