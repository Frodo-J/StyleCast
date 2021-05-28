package com.stylecast.main.model.vo;

public class MainSelectCodi {
	
	private int codiNo;
	private String imgPath;
	
	public MainSelectCodi(int codiNo, String imgPath) {
		super();
		this.codiNo = codiNo;
		this.imgPath = imgPath;
	}

	public int getCodiNo() {
		return codiNo;
	}

	public void setCodiNo(int codiNo) {
		this.codiNo = codiNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "MainSelectCodi [codiNo=" + codiNo + ", imgPath=" + imgPath + "]";
	}
	
	
}
