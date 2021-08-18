package com.nagal.design;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignApplication {

	public static void main(String[] args) {

//		Builder Pattern.
//		Phone p = new PhoneBuilder().setBattery(4550).setOs("Android").getPhone();
//		Phone p= Phone.builder().battery(563).processor("rag").build();
//		System.out.println(p);

//		Singleton Pattern
//		AirforceOne airforceOne= AirforceOne.getAirForceOne();
//		airforceOne.fly();
//
//		AirforceOne airforceOne1= AirforceOne.getAirForceOne();
//		airforceOne1.fly();
//      static initialization creates the object even if it's not used in a particular run of the application.

//        double mass = 10.0;
//		double height = 3.7;
//		Position position = new Position(3, 7);
//		MangoTree mangoTree = new MangoTree(mass, height);
//		mangoTree.setPosition(position);
//
//		MangoTree otherTree= (MangoTree) mangoTree.copy();
////		mangoTree.setPosition(new Position(4,5));
//		System.out.println(mangoTree);
//		System.out.println(otherTree);

		String a="ragi";
		String b=new String("ragi");
		System.out.println(a.equals(b));

	}
}
