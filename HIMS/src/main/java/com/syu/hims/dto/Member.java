package com.syu.hims.dto;

public class Member {
	private String userid;
	private String userpw;
	private String username;
	private String mobile;
	private String mobileId;
	private String email;
	private String birth;
	private String grade;
	private String useCount;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUseCount() {
		return useCount;
	}
	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}
	public Member(String userid, String userpw, String username, String mobile, String mobileId, String email,
			String birth, String grade, String useCount) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.mobile = mobile;
		this.mobileId = mobileId;
		this.email = email;
		this.birth = birth;
		this.grade = grade;
		this.useCount = useCount;
	}
	public Member(String userid, String userpw, String username, String mobile, String email, String birth) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.birth = birth;
	}
	public Member(String userid, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
	}
	public Member(String userid) {
		super();
		this.userid = userid;
	}
	public Member() {}
	
}
