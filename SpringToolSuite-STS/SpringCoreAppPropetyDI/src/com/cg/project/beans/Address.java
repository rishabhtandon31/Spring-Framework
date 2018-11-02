package com.cg.project.beans;

public class Address {
	private String city,state,country;
	private int pinCode;
	public Address() {
		super();
	}
	/*public Address(String city, String state, String country, int pinCode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}*/
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	
}
