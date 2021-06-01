package com.stylecast.daily.model.vo;

import java.sql.Date;

public class DailyCM {

	private int cmNo;
	private int memNo;
	private int dailyNo;
	private String cmContent;
	private Date enrDate;
	
	private String memName;
	private String profImg;
	
	public DailyCM() {}

	public DailyCM(int cmNo, int memNo, int dailyNo, String cmContent, Date enrDate) {
		super();
		this.cmNo = cmNo;
		this.memNo = memNo;
		this.dailyNo = dailyNo;
		this.cmContent = cmContent;
		this.enrDate = enrDate;
	}

	public DailyCM(int cmNo, int memNo, String cmContent, Date enrDate, String memName, String profImg) {
		super();
		this.cmNo = cmNo;
		this.memNo = memNo;
		this.cmContent = cmContent;
		this.enrDate = enrDate;
		this.memName = memName;
		this.profImg = profImg;
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getDailyNo() {
		return dailyNo;
	}

	public void setDailyNo(int dailyNo) {
		this.dailyNo = dailyNo;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public Date getEnrDate() {
		return enrDate;
	}

	public void setEnrDate(Date enrDate) {
		this.enrDate = enrDate;
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

	@Override
	public String toString() {
		return "Daily_CM [cmNo=" + cmNo + ", memNo=" + memNo + ", dailyNo=" + dailyNo + ", cmContent=" + cmContent
				+ ", enrDate=" + enrDate + "]";
	}
	
	
}
