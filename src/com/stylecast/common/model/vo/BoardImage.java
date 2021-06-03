package com.stylecast.common.model.vo;

public class BoardImage {
	
	private int imgNo;
	private String imgPath;
	private int postCategory;
	private int postNo;
	
	public BoardImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardImage(int imgNo, String imgPath, int postCategory, int postNo) {
		super();
		this.imgNo = imgNo;
		this.imgPath = imgPath;
		this.postCategory = postCategory;
		this.postNo = postNo;
	}
	
	public BoardImage(String imgPath) {
		// TODO Auto-generated constructor stub
		this.imgPath = imgPath;
	}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(int postCategory) {
		this.postCategory = postCategory;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "Image [imgNo=" + imgNo + ", imgPath=" + imgPath + ", postCategory=" + postCategory + ", postNo="
				+ postNo + "]";
	}
	
	
	
}
