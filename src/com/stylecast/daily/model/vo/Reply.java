package com.stylecast.daily.model.vo;

import java.sql.Date;

public class Reply {
	
	private int cmNo;
	private int memNo;
	private int dailyNo;
	private String cmContent;
	private Date enrDate;

	public Reply() {}

	public Reply(int cmNo, int memNo, int dailyNo, String cmContent, Date enrDate) {
		super();
		this.cmNo = cmNo;
		this.memNo = memNo;
		this.dailyNo = dailyNo;
		this.cmContent = cmContent;
		this.enrDate = enrDate;
	}
	
	

	public Reply(int cmNo, int dailyNo, String cmContent, Date enrDate) {
		super();
		this.cmNo = cmNo;
		this.dailyNo = dailyNo;
		this.cmContent = cmContent;
		this.enrDate = enrDate;
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

	@Override
	public String toString() {
		return "Reply [cmNo=" + cmNo + ", memNo=" + memNo + ", dailyNo=" + dailyNo + ", cmContent=" + cmContent
				+ ", enrDate=" + enrDate + "]";
	}
	
}
