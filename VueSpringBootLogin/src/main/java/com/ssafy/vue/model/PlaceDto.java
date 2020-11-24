package com.ssafy.vue.model;

public class PlaceDto {
	private String placeId;
	private String placeName;
	private String address;
	private String dongcode;
	private String dongname;
	private String lng;
	private String lat;
	private String type;
	
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PlaceDto [placeId=" + placeId + ", placeName=" + placeName + ", address=" + address + ", dongcode="
				+ dongcode + ", dongname=" + dongname + ", lng=" + lng + ", lat=" + lat + ", type=" + type + "]";
	}	
}
