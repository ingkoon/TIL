package com.ssafy.housedeal.model;

public class HouseDealInfo {
	String apartName;
	String floor;
	String area;
	String dong;
	String dealAmount;
	String lng;
	String lat;
	
	public HouseDealInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HouseDealInfo(String apartName, String floor, String area, String dong, String dealAmount, String lng,
			String lat) {
		super();
		this.apartName = apartName;
		this.floor = floor;
		this.area = area;
		this.dong = dong;
		this.dealAmount = dealAmount;
		this.lng = lng;
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "HouseDealInfo [apartName=" + apartName + ", floor=" + floor + ", area=" + area + ", dong=" + dong
				+ ", dealAmount=" + dealAmount + ", lng=" + lng + ", lat=" + lat + "]";
	}

	public String getApartName() {
		return apartName;
	}

	public void setApartName(String apartName) {
		this.apartName = apartName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
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
	
}
