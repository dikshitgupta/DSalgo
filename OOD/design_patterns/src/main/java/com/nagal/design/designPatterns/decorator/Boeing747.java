package com.nagal.design.designPatterns.decorator;

public class Boeing747 implements IAircraft {

	@Override  // this override key word is not actuallyn needed but can help when if you are making any errors
	public void fly() {
		System.out.println("Boeing-747 flying ...");
	}

	@Override
	public void land() {
		System.out.println("Boeing-747 landing ...");
	}

	@Override
	public float getWeight() {
		return baseWeight;
	}
}

