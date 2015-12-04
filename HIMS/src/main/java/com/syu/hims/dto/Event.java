package com.syu.hims.dto;

public class Event {
	private int beaconMinor;
	private String facName;
	private String eventTime;
	private String winner;
	public int getBeaconMinor() {
		return beaconMinor;
	}
	public void setBeaconMinor(int beaconMinor) {
		this.beaconMinor = beaconMinor;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public Event() {}
	public Event(int beaconMinor, String facName, String eventTime) {
		super();
		this.beaconMinor = beaconMinor;
		this.facName = facName;
		this.eventTime = eventTime;
	}
	public Event(int beaconMinor, String facName, String eventTime, String winner) {
		super();
		this.beaconMinor = beaconMinor;
		this.facName = facName;
		this.eventTime = eventTime;
		this.winner = winner;
	}
	
}
