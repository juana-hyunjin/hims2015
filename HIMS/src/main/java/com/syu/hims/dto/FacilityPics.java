package com.syu.hims.dto;

import org.springframework.web.multipart.MultipartFile;

public class FacilityPics {
	private int picsNo;
	private String picsPath;
	private String facNo;
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
	public String getFacNo() {
		return facNo;
	}
	public void setFacNo(String facNo) {
		this.facNo = facNo;
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
	public FacilityPics(int picsNo, String picsPath, String facNo, String orgName, String newName) {
		super();
		this.picsNo = picsNo;
		this.picsPath = picsPath;
		this.facNo = facNo;
		this.orgName = orgName;
		this.newName = newName;
	}
	public FacilityPics() {}
}
