package com.syu.hims.dto;

import org.springframework.web.multipart.MultipartFile;

public class RoomPics {
	private int picsNo;
	private String picsPath;
	private int roomTypeNo;
	private String orgName;
	private String newName;
	private MultipartFile file; //파일업로드용
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getPicsNo() {
		return picsNo;
	}
	public void setPicsNo(int picsNo) {
		this.picsNo = picsNo;
	}
	public String getPicsPath() {
		return picsPath;
	}
	public void setPicsPath(String picsPath) {
		this.picsPath = picsPath;
	}
	public int getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public RoomPics(int picsNo, String picsPath, int roomTypeNo, String orgName, String newName) {
		super();
		this.picsNo = picsNo;
		this.picsPath = picsPath;
		this.roomTypeNo = roomTypeNo;
		this.orgName = orgName;
		this.newName = newName;
	}
	public RoomPics(String picsPath, int roomTypeNo, String orgName, String newName) {
		super();
		this.picsPath = picsPath;
		this.roomTypeNo = roomTypeNo;
		this.orgName = orgName;
		this.newName = newName;
	}
	public RoomPics() {}
}
