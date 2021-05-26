package com.stylecast.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private int memNo;
	private String noticeTitle;
	private String noticeContent;
	private int count;
	private Date enrDate;
	private String status;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int noticeNo, int memNo, String noticeTitle, String noticeContent, int count, Date enrDate,
			String status) {
		super();
		this.noticeNo = noticeNo;
		this.memNo = memNo;
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

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
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

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memNo=" + memNo + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", count=" + count + ", enrDate=" + enrDate + ", status=" + status + "]";
	}

	
	
	
}
