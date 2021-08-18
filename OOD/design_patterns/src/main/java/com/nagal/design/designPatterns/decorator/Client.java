package com.nagal.design.designPatterns.decorator;

public class Client {

	public static void main(String[] args) {
		IAircraft simpleBoeing = new Boeing747();
		IAircraft luxuriousBoeing = new LuxuryFittings(simpleBoeing);
		IAircraft bulletProofBoeing = new BulletProof(luxuriousBoeing);
		float netWeight = bulletProofBoeing.getWeight();
		bulletProofBoeing.fly();
		System.out.println("Final weight of the plane: " + netWeight);

	}
}
