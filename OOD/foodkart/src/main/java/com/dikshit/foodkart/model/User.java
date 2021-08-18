package com.dikshit.foodkart.model;

import java.util.UUID;

public class User {
	String name;
	Gender gender;
	String phoneNumber;
	String pincode;
	int userId;

	public User(String name, Gender gender, String phoneNumber, String pincode) {
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.pincode = pincode;
		this.userId= com.dikshit.foodkart.model.userId.getId();
	}

	public int getUserId() {
		return userId;
	}

	public String getPincode() {
		return pincode;
	}

}
