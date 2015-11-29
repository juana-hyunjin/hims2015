package com.syu.hims.dto;

public class Reservation {
	private int rsvNo;
	private String userid;
	private int roomTypeNo;
	private int headCount;
	private String chkInDate;
	private String chkOutDate;
	private String memo;
	
	private String mobile;
	private String typeName;
	private String username;
	
	public int getRsvNo() {
		return rsvNo;
	}
	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public String getChkInDate() {
		return chkInDate;
	}
	public void setChkInDate(String chkInDate) {
		this.chkInDate = chkInDate;
	}
	public String getChkOutDate() {
		return chkOutDate;
	}
	public void setChkOutDate(String chkOutDate) {
		this.chkOutDate = chkOutDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Reservation(int rsvNo, String userid, int roomTypeNo, int headCount, String chkInDate, String chkOutDate,
			String memo, String mobile, String typeName, String username) {
		super();
		this.rsvNo = rsvNo;
		this.userid = userid;
		this.roomTypeNo = roomTypeNo;
		this.headCount = headCount;
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
		this.memo = memo;
		this.mobile = mobile;
		this.typeName = typeName;
		this.username = username;
	}
	public Reservation(int rsvNo, String userid, int roomTypeNo, int headCount, String chkInDate, String chkOutDate,
			String memo) {
		super();
		this.rsvNo = rsvNo;
		this.userid = userid;
		this.roomTypeNo = roomTypeNo;
		this.headCount = headCount;
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
		this.memo = memo;
	}
	public Reservation(int rsvNo, String userid, int roomTypeNo, int headCount, String chkInDate, String chkOutDate) {
		super();
		this.rsvNo = rsvNo;
		this.userid = userid;
		this.roomTypeNo = roomTypeNo;
		this.headCount = headCount;
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
	}
	public Reservation(int rsvNo, String userid, int roomTypeNo, int headCount, String chkInDate, String chkOutDate,
			String memo, String mobile, String typeName) {
		super();
		this.rsvNo = rsvNo;
		this.userid = userid;
		this.roomTypeNo = roomTypeNo;
		this.headCount = headCount;
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
		this.memo = memo;
		this.mobile = mobile;
		this.typeName = typeName;
	}
	public Reservation(int rsvNo) {
		super();
		this.rsvNo = rsvNo;
	}
	public Reservation() {}
	
}
