package com.stylecast.admin.model.vo;

public class Codi {
	
	private int codiNo;
	private String gender;
	private String imgPath;
	private String recWeather;
	private int recLowT;
	private int recHighT;
	
	public Codi() {}
	
	public Codi(int codiNo, String gender, String imgPath, String recWeather, int recLowT, int recHighT) {
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



	public int getRecLowT() {
		return recLowT;
	}



	public void setRecLowT(int lowT) {
		this.recLowT = lowT;
	}



	public int getRecHighT() {
		return recHighT;
	}



	public void setRecHighT(int highT) {
		this.recHighT = highT;
	}



	@Override
	public String toString() {
		return "Codi [codiNo=" + codiNo + ", gender=" + gender + ", imgPath=" + imgPath + ", recWeather=" + recWeather
				+ ", recLowT=" + recLowT + ", recHighT=" + recHighT + "]";
	}

	
}
