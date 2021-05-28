package com.stylecast.main.model.vo;

public class MainSelectDaily {
	
	private int dailyNo;
	private String dailyImg;
	
	public MainSelectDaily() {}
	

	public MainSelectDaily(int dailyNo, String dailyImg) {
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
