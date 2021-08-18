package com.HLMS.HLMS.model;

import com.HLMS.HLMS.actors.HouseKeeper;

import java.util.Date;

public class HouseKeepingLog {

	String description;
	Date startDate;
	int duration;
	HouseKeeper houseKeeper;

	public void addRoom(Room room){
		HouseKeepingLog houseKeepingLog=new HouseKeepingLog();
		room.houseKeepingLogList.add(houseKeepingLog);
	}

}
