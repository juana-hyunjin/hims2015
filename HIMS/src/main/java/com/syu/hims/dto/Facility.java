package com.syu.hims.dto;

public class Facility {
	private int facNo;
	private String facName;
	private String facInfo;
	private String availability;
	private int beaconMinor;
	public int getFacNo() {
		return facNo;
	}
	public void setFacNo(int facNo) {
		this.facNo = facNo;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public String getFacInfo() {
		return facInfo;
	}
	public void setFacInfo(String facInfo) {
		this.facInfo = facInfo;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getBeaconMinor() {
		return beaconMinor;
	}
	public void setBeaconMinor(int beaconMinor) {
		this.beaconMinor = beaconMinor;
	}
	public Facility(int facNo, String facName, String facInfo, String availability, int beaconMinor) {
		super();
		this.facNo = facNo;
		this.facName = facName;
		this.facInfo = facInfo;
		this.availability = availability;
		this.beaconMinor = beaconMinor;
	}
	public Facility() {}
}
