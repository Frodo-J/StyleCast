package com.stylecast.member.vo;

import java.util.Date;

public class Member {

	private int memNo;
	private String memId;
	private String memPwd; 
	private String memName;
	private String email;
	private String gender;
	private Date enrollDate;
	private String blackYN;
	private String entYN;
	private int warning;
	private String adminYN;
	private Date updateDate;
	private Date entDate;
	private String profImg;
	
	public Member() {}

	public Member(int memNo, String memId, String memPwd, String memName, String email, String gender, Date enrollDate,
			String blackYN, String entYN, int warning, String adminYN, Date updateDate, Date entDate, String profImg) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
		this.gender = gender;
		this.enrollDate = enrollDate;
		this.blackYN = blackYN;
		this.entYN = entYN;
		this.warning = warning;
		this.adminYN = adminYN;
		this.updateDate = updateDate;
		this.entDate = entDate;
		this.profImg = profImg;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getBlackYN() {
		return blackYN;
	}

	public void setBlackYN(String blackYN) {
		this.blackYN = blackYN;
	}

	public String getEntYN() {
		return entYN;
	}

	public void setEntYN(String entYN) {
		this.entYN = entYN;
	}

	public int getWarning() {
		return warning;
	}

	public void setWarning(int warning) {
		this.warning = warning;
	}

	public String getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public String getProfImg() {
		return profImg;
	}

	public void setProfImg(String profImg) {
		this.profImg = profImg;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName
				+ ", email=" + email + ", gender=" + gender + ", enrollDate=" + enrollDate + ", blackYN=" + blackYN
				+ ", entYN=" + entYN + ", warning=" + warning + ", adminYN=" + adminYN + ", updateDate=" + updateDate
				+ ", entDate=" + entDate + ", profImg=" + profImg + "]";
	}
	
}
