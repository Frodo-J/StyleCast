package com.stylecast.theme.model.vo;

public class ThemePost {

	private int themeNo;
	private int dailyNo;
	
	private String dailyImg;
	
	public ThemePost() {}

	public ThemePost(int themeNo, int dailyNo) {
		super();
		this.themeNo = themeNo;
		this.dailyNo = dailyNo;
	}

	
	public ThemePost(int dailyNo, String dailyImg) {
		super();
		this.dailyNo = dailyNo;
		this.dailyImg = dailyImg;
	}

	public int getThemeNo() {
		return themeNo;
	}

	public void setThemeNo(int themeNo) {
		this.themeNo = themeNo;
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
		return "ThemePost [themeNo=" + themeNo + ", dailyNo=" + dailyNo + ", dailyImg=" + dailyImg + "]";
	}

	
}
