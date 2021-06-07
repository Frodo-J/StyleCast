package com.stylecast.daily.model.vo;

import java.sql.Date;

public class Report {

	private int rptNo;
	private int memNo;
	private int rMemNo;
	private String content;
	private Date enrDate;
	private String status;
	private int brCategory;
	private int dailyNo;
	private String rptCategory;
	private int cmNo;
	
	private String memId;
	private String rMemId;
	
	public Report() {}
	
	

	public Report(int rptNo, int memNo, int rMemNo, String content, Date enrDate, String status, int brCategory,
			int dailyNo, String rptCategory, int cmNo, String memId, String rMemId) {
		super();
		this.rptNo = rptNo;
		this.memNo = memNo;
		this.rMemNo = rMemNo;
		this.content = content;
		this.enrDate = enrDate;
		this.status = status;
		this.brCategory = brCategory;
		this.dailyNo = dailyNo;
		this.rptCategory = rptCategory;
		this.cmNo = cmNo;
		this.memId = memId;
		this.rMemId = rMemId;
	}
	
	public Report(int rptNo, String content, Date enrDate, int brCategory, int dailyNo, String rptCategory, int cmNo,
			String memId, String rMemId) {
		super();
		this.rptNo = rptNo;
		this.content = content;
		this.enrDate = enrDate;
		this.brCategory = brCategory;
		this.dailyNo = dailyNo;
		this.rptCategory = rptCategory;
		this.cmNo = cmNo;
		this.memId = memId;
		this.rMemId = rMemId;
	}
	
	
	public Report(int rptNo) {
		super();
		this.rptNo = rptNo;
	}


	public int getRptNo() {
		return rptNo;
	}

	public void setRptNo(int rptNo) {
		this.rptNo = rptNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getrMemNo() {
		return rMemNo;
	}

	public void setrMemNo(int rMemNo) {
		this.rMemNo = rMemNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEnrDate() {
		return enrDate;
	}

	public void setEnrDate(Date enrDate) {
		this.enrDate = enrDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBrCategory() {
		return brCategory;
	}

	public void setBrCategory(int brCategory) {
		this.brCategory = brCategory;
	}

	public int getDailyNo() {
		return dailyNo;
	}

	public void setDailyNo(int dailyNo) {
		this.dailyNo = dailyNo;
	}

	public String getRptCategory() {
		return rptCategory;
	}

	public void setRptCategory(String rptCategory) {
		this.rptCategory = rptCategory;
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getrMemId() {
		return rMemId;
	}

	public void setrMemId(String rMemId) {
		this.rMemId = rMemId;
	}

	@Override
	public String toString() {
		return "Report [rptNo=" + rptNo + ", memNo=" + memNo + ", rMemNo=" + rMemNo + ", content=" + content
				+ ", enrDate=" + enrDate + ", status=" + status + ", brCategory=" + brCategory + ", dailyNo=" + dailyNo
				+ ", rptCategory=" + rptCategory + ", cmNo=" + cmNo + ", memId=" + memId + ", rMemId=" + rMemId + "]";
	}
	
}
