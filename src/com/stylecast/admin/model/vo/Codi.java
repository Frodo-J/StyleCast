package com.stylecast.admin.model.vo;

public class Codi {
	
	private int codiNo;
	private String gender;
	private String imgPath;
	private String recWeather;
	private String recLowT;
	private String recHighT;
	
	public Codi() {}
	
	public Codi(int codiNo, String gender, String imgPath, String recWeather, String recLowT, String recHighT) {
		super();
		this.codiNo = codiNo;
		this.gender = gender;
		this.imgPath = imgPath;
		this.recWeather = recWeather;
		this.recLowT = recLowT;
		this.recHighT = recHighT;
	}
	
	public int getCodiNo() {
		return codiNo;
	}



	public void setCodiNo(int codiNo) {
		this.codiNo = codiNo;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getImgPath() {
		return imgPath;
	}



	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



	public String getRecWeather() {
		return recWeather;
	}



	public void setRecWeather(String recWeather) {
		this.recWeather = recWeather;
	}



	public String getRecLowT() {
		return recLowT;
	}



	public void setRecLowT(String recLowT) {
		this.recLowT = recLowT;
	}



	public String getRecHighT() {
		return recHighT;
	}



	public void setRecHighT(String recHighT) {
		this.recHighT = recHighT;
	}



	@Override
	public String toString() {
		return "Codi [codiNo=" + codiNo + ", gender=" + gender + ", imgPath=" + imgPath + ", recWeather=" + recWeather
				+ ", recLowT=" + recLowT + ", recHighT=" + recHighT + "]";
	}

	
}
