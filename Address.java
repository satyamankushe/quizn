package com.miniproject.Quiz;

public class Address {
	String city;
	String street;
	int pincode;
	String getCity() {
		return city;
	}
	
	public Address(String city, String street, int pincode) {
		this.city = city;
		this.street = street;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return city+", "+street+", "+pincode;
	}

	String getStreet() {
		return street;
	}
	
	int getPincode() {
		return pincode;
	}
	

}
