package com.HLMS.HLMS.model;

import com.HLMS.HLMS.enums.RoomStatus;
import com.HLMS.HLMS.enums.RoomType;

import java.util.List;

public class Room {
	String roomNumber;
	RoomType roomType;
	RoomStatus roomStatus;
	Double bookingPrice;
	List<Roomkey> roomKeys;
	List <HouseKeepingLog> houseKeepingLogList;    // because housekeeping log is specific to a particular room
}
