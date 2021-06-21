package com.nagal.design.singleton;

public class AirforceOne {

	private static AirforceOne airforceOne;

	private AirforceOne(){
		System.out.println("Instance of Airforce once called");
	}

	public void fly(){
		System.out.println("Aircraft is flying");
	}

	public static AirforceOne getAirforceOne(){

		if(airforceOne==null){
			airforceOne=new AirforceOne();
		}

		return airforceOne;
	}
}

