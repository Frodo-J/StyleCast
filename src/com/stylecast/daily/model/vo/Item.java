package com.stylecast.daily.model.vo;

public class Item {

	private int itemNo;
	private int dailyNo;
	private String itemName;
	private String itemLink;
	private String itemCategory;
	
	public Item() {}
	
	public Item(int itemNo, int dailyNo, String itemName, String itemLink, String itemCategory) {
		super();
		this.itemNo = itemNo;
		this.dailyNo = dailyNo;
		this.itemName = itemName;
		this.itemLink = itemLink;
		this.itemCategory = itemCategory;
	}

	public Item(int itemNo, String itemName, String itemLink, String itemCategory) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemLink = itemLink;
		this.itemCategory = itemCategory;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getDailyNo() {
		return dailyNo;
	}

	public void setDailyNo(int dailyNo) {
		this.dailyNo = dailyNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", dailyNo=" + dailyNo + ", itemName=" + itemName + ", itemLink=" + itemLink
				+ ", itemCategory=" + itemCategory + "]";
	}
	
}
