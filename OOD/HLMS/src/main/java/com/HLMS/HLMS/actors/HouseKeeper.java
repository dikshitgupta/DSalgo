package com.HLMS.HLMS.actors;

import com.HLMS.HLMS.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HouseKeeper extends Person {

	public List<Room> getRoomServiced(Date Date){
		return new ArrayList<Room>(Arrays.asList(new Room()));
	}

}
