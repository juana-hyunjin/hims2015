package com.syu.hims.dto;

public class RoomType {
	private int roomNo;
	private String floor;
	private String price;
	private String limitNum;
	private String bed;
	private String typeName;
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(String limitNum) {
		this.limitNum = limitNum;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public RoomType(int roomNo, String floor, String price, String limitNum, String bed, String typeName) {
		super();
		this.roomNo = roomNo;
		this.floor = floor;
		this.price = price;
		this.limitNum = limitNum;
		this.bed = bed;
		this.typeName = typeName;
	}
	public RoomType(int roomNo, String floor, String price, String limitNum, String bed) {
		super();
		this.roomNo = roomNo;
		this.floor = floor;
		this.price = price;
		this.limitNum = limitNum;
		this.bed = bed;
	}
	public RoomType() {}
}
