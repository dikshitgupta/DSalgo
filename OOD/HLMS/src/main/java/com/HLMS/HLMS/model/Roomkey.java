package com.HLMS.HLMS.model;

import com.HLMS.HLMS.model.Room;

import java.util.Date;

public class Roomkey {
	String Keyid;
	String barCode;
	Date issuedAt;
	Boolean isActive;
	Boolean isMaster;

	public void assignRoom(Room room); //  assign this particular roomkey to the list of keys of that particular room


}
