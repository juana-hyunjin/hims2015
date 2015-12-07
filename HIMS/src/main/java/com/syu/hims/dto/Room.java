
package com.syu.hims.dto;

public class Room {
	private String roomNo;
	private String floor;
	private String availability;
	private int roomTypeNo;
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public Room(String roomNo, String floor, String availability, int roomTypeNo) {
		super();
		this.roomNo = roomNo;
		this.floor = floor;
		this.availability = availability;
		this.roomTypeNo = roomTypeNo;
	}
	public Room() {}
	
	
}
