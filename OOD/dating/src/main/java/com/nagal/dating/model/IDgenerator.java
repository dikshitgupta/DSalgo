package com.nagal.dating.model;

public class IDgenerator {
	private static int id=0;

	public static int getID(){
		id++;
		return id;
	}

}
