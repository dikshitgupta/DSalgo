package com.nagal.design.singleton;

public class AirforceOne {

	private static AirforceOne airforceOne;  // only instance of this class.

	private AirforceOne(){
		System.out.println("Instance of Airforce once called");
	}  // we use private constructor in Singleton DEsing pattern.

	public void fly(){
		System.out.println("Aircraft is flying");
	}

	public static AirforceOne getAirForceOne(){

		if(airforceOne==null){
			airforceOne=new AirforceOne();
		}

		return airforceOne;
	}
}

