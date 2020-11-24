package com.ssafy.vue.model;

public class MyPageDto {
	private String no;
	private String userId;
	private String aptName;
	private String dealAmount;
	private String dealYear;
	private String dong;
	private String buildYear;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	@Override
	public String toString() {
		return "MyPageDto [no=" + no + ", userId=" + userId + ", aptName=" + aptName + ", dealAmount=" + dealAmount
				+ ", dealYear=" + dealYear + ", dong=" + dong + ", buildYear=" + buildYear + "]";
	}
	
	
}
