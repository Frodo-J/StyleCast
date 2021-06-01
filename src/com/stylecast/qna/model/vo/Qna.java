package com.stylecast.qna.model.vo;

import java.sql.Date;

public class Qna {
	
	private int qnaNo;
	private int memNo;
	private String memName;
	private String qnaTitle;
	private String qnaContent;
	private Date enrDate;
	private int memAdmin;
	private String memAdminName;
	private String ansContent;
	private Date ansDate;
	private String ansDate2;
	private String qnaCategory;
	
	public Qna() {
		super();
	}
	
	public Qna(int qnaNo, int memNo, String qnaTitle, String qnaContent, Date enrDate, int memAdmin, String ansContent,
			Date ansDate, String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.memNo = memNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.enrDate = enrDate;
		this.memAdmin = memAdmin;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.qnaCategory = qnaCategory;
	}
	
	

	public Qna(int qnaNo, int memNo, String memName, String qnaTitle, String qnaContent, Date enrDate, int memAdmin,
			String ansContent, Date ansDate, String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.memNo = memNo;
		this.memName = memName;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.enrDate = enrDate;
		this.memAdmin = memAdmin;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.qnaCategory = qnaCategory;
	}

	public Qna(int qnaNo, String qnaCategory, String qnaTitle,String memName, Date enrDate, String ansContent) {
		super();
		this.qnaNo = qnaNo;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.memName = memName;
		this.enrDate = enrDate;
		this.ansContent = ansContent;
	}

	public Qna(int qnaNo, String qnaTitle, Date enrDate, String ansContent) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.enrDate = enrDate;
		this.ansContent = ansContent;
	}
	
	public Qna(int qnaNo, String qnaCategory, String qnaTitle, String memName, String qnaContent, Date enrDate) {
		this.qnaNo = qnaNo;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.memName = memName;
		this.qnaContent = qnaContent;
		this.enrDate = enrDate;
	}

	public Qna(int qnaNo, String qnaCategory, String qnaTitle, String memName, String qnaContent, Date enrDate, String memAdminName,
			String ansContent, Date ansDate) {
		// TODO Auto-generated constructor stub
		this.qnaNo = qnaNo;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.memName = memName;
		this.qnaContent = qnaContent;
		this.enrDate = enrDate;
		this.memAdminName = memAdminName;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
	}

	public Qna(int qnaNo, int memNo, String memName, String qnaTitle, String qnaContent, Date enrDate, int memAdmin,
			String memAdminName, String ansContent, Date ansDate, String ansDate2, String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.memNo = memNo;
		this.memName = memName;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.enrDate = enrDate;
		this.memAdmin = memAdmin;
		this.memAdminName = memAdminName;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.ansDate2 = ansDate2;
		this.qnaCategory = qnaCategory;
	}

	public Qna(String memAdminName, String ansContent, String ansDate2) {
		super();
		this.memAdminName = memAdminName;
		this.ansContent = ansContent;
		this.ansDate2 = ansDate2;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getEnrDate() {
		return enrDate;
	}

	public void setEnrDate(Date enrDate) {
		this.enrDate = enrDate;
	}

	public int getMemAdmin() {
		return memAdmin;
	}

	public void setMemAdmin(int memAdmin) {
		this.memAdmin = memAdmin;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public String getQnaCategory() {
		return qnaCategory;
	}

	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}
	
	

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemAdminName() {
		return memAdminName;
	}

	public void setMemAdminName(String memAdminName) {
		this.memAdminName = memAdminName;
	}
	
	

	public String getAnsDate2() {
		return ansDate2;
	}

	public void setAnsDate2(String ansDate2) {
		this.ansDate2 = ansDate2;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", memNo=" + memNo + ", memName=" + memName + ", qnaTitle=" + qnaTitle
				+ ", qnaContent=" + qnaContent + ", enrDate=" + enrDate + ", memAdmin=" + memAdmin + ", ansContent="
				+ ansContent + ", ansDate=" + ansDate + ", qnaCategory=" + qnaCategory + "]";
	}

	
	
}
