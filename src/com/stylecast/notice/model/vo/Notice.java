package com.stylecast.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private String memNo;
	private String memName;
	private String noticeTitle;
	private String noticeContent;
	private int count;
	private Date enrDate;
	private String status;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int noticeNo, String memName, String noticeTitle, String noticeContent, int count, Date enrDate,
			String status) {
		super();
		this.noticeNo = noticeNo;
		this.memName = memName;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.enrDate = enrDate;
		this.status = status;
	}
	
	
	public Notice(int noticeNo, String memName, String noticeTitle, String noticeContent, int count, Date enrDate) {
		super();
		this.noticeNo = noticeNo;
		this.memName = memName;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.enrDate = enrDate;
	}

	public Notice(int noticeNo, String memName, String noticeTitle, Date enrDate) {
		super();
		this.noticeNo = noticeNo;
		this.memName = memName;
		this.noticeTitle = noticeTitle;
		this.enrDate = enrDate;
	}
	

	public Notice(int noticeNo, String memNo, String memName, String noticeTitle, String noticeContent, int count,
			Date enrDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.memNo = memNo;
		this.memName = memName;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.enrDate = enrDate;
		this.status = status;
	}

	public int getNoticeNo() {
		return noticeNo;
	}
	
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	
	public String getMemName() {
		return memName;
	}
	
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}
	
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
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
	
	

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memNo=" + memNo + ", memName=" + memName + ", noticeTitle="
				+ noticeTitle + ", noticeContent=" + noticeContent + ", count=" + count + ", enrDate=" + enrDate
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
