package com.stylecast.daily.model.vo;

import java.sql.Date;

public class Daily {

	private int dailyNo;
	private int memNo;
	private String dailyContent;
	private Date enrDate;
	private String dailyImg;
	private String tag;
	
	private String memName;
	private String profImg;
	
	public Daily() {}

	public Daily(int dailyNo, int memNo, String dailyContent, Date enrDate, String dailyImg, String tag) {
		super();
		this.dailyNo = dailyNo;
		this.memNo = memNo;
		this.dailyContent = dailyContent;
		this.enrDate = enrDate;
		this.dailyImg = dailyImg;
		this.tag = tag;
	}

	public Daily(int dailyNo, int memNo, String dailyContent, Date enrDate, String dailyImg, String tag, String memName,
			String profImg) {
		super();
		this.dailyNo = dailyNo;
		this.memNo = memNo;
		this.dailyContent = dailyContent;
		this.enrDate = enrDate;
		this.dailyImg = dailyImg;
		this.tag = tag;
		this.memName = memName;
		this.profImg = profImg;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getProfImg() {
		return profImg;
	}

	public void setProfImg(String profImg) {
		this.profImg = profImg;
	}

	public int getDailyNo() {
		return dailyNo;
	}

	public void setDailyNo(int dailyNo) {
		this.dailyNo = dailyNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getDailyContent() {
		return dailyContent;
	}

	public void setDailyContent(String dailyContent) {
		this.dailyContent = dailyContent;
	}

	public Date getEnrDate() {
		return enrDate;
	}

	public void setEnrDate(Date enrDate) {
		this.enrDate = enrDate;
	}

	public String getDailyImg() {
		return dailyImg;
	}

	public void setDailyImg(String dailyImg) {
		this.dailyImg = dailyImg;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Daily [dailyNo=" + dailyNo + ", memNo=" + memNo + ", dailyContent=" + dailyContent + ", enrDate="
				+ enrDate + ", dailyImg=" + dailyImg + ", tag=" + tag + "]";
	}
	
	
}
