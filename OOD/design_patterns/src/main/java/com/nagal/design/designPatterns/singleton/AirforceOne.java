package com.nagal.design.designPatterns.singleton;
/*
People argue that you should't ever use it
Ensure that a class a single instance, and ensure global access to it.
Not a good idea to use it mostly, it is fine to use a single object.

 */

public class AirforceOne {

	private static AirforceOne airforceOne;  // only instance of this class.
	int price;

	private AirforceOne(){
		price=10000;
		System.out.println("Instance of Airforce once called");
	}  // we use private constructor in Singleton Design pattern.

	public void fly(){
		System.out.println("Aircraft is flying");
	}

	public static AirforceOne getAirForceOne(){

		if(airforceOne==null){
			airforceOne=new AirforceOne();
		}

		return airforceOne;
	}


	public static void main(String[] args) {
		AirforceOne a=getAirForceOne();
		a.fly();
	}

}


