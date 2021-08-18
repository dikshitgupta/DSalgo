package com.nagal.design.designPatterns.decorator;

public class LuxuryFittings extends BoeingDecorator {

	IAircraft boeing;

	public LuxuryFittings(IAircraft boeing) {
		this.boeing = boeing;
	}

	@Override
	public void fly() {
		System.out.println("Fly inside luxury boeing");
		boeing.fly();
	}

	@Override
	public void land() {
		boeing.land();
	}

	@Override
	public float getWeight() {
		return (30.5f + boeing.getWeight());
	}
}
