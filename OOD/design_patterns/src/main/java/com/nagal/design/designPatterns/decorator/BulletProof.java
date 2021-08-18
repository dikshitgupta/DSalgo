package com.nagal.design.designPatterns.decorator;

public class BulletProof extends BoeingDecorator {

	IAircraft boeing;

	public BulletProof(IAircraft boeing) {
		this.boeing = boeing;
	}

	@Override
	public void fly() {
		System.out.println("Fly inside bullet boeing");
		boeing.fly();
	}

	@Override
	public void land() {
		boeing.land();
	}

	@Override
	public float getWeight() {
		return 50f + boeing.getWeight();
	}

}
