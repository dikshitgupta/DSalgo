package com.dikshit.foodkart.model;

public class userId {
	private static int userid=0;

	public static int getId() {
		userid++;
		return userid;
	}

}
