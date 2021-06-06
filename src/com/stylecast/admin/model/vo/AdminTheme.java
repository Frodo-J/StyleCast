package com.stylecast.admin.model.vo;

import java.sql.Date;

public class AdminTheme {

	private int themeNo;
	private String themeTitle;
	private String themeTitleColor;
	private String themeSubtitle;
	private Date enrDate;
	private String status;
	
	public AdminTheme() {}

	public AdminTheme(int themeNo, String themeTitle, String themeTitleColor, String themeSubtitle, Date enrDate,
			String status) {
		super();
		this.themeNo = themeNo;
		this.themeTitle = themeTitle;
		this.themeTitleColor = themeTitleColor;
		this.themeSubtitle = themeSubtitle;
		this.enrDate = enrDate;
		this.status = status;
	}

	public AdminTheme(int themeNo, String themeTitle, String themeSubtitle, String status) {
		super();
		this.themeNo = themeNo;
		this.themeTitle = themeTitle;
		this.themeSubtitle = themeSubtitle;
		this.status = status;
	}

	public int getThemeNo() {
		return themeNo;
	}

	public void setThemeNo(int themeNo) {
		this.themeNo = themeNo;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public String getThemeTitleColor() {
		return themeTitleColor;
	}

	public void setThemeTitleColor(String themeTitleColor) {
		this.themeTitleColor = themeTitleColor;
	}

	public String getThemeSubtitle() {
		return themeSubtitle;
	}

	public void setThemeSubtitle(String themeSubtitle) {
		this.themeSubtitle = themeSubtitle;
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
		return "AdminTheme [themeNo=" + themeNo + ", themeTitle=" + themeTitle + ", themeTitleColor=" + themeTitleColor
				+ ", themeSubtitle=" + themeSubtitle + ", enrDate=" + enrDate + ", status=" + status + "]";
	}
	
	
}
