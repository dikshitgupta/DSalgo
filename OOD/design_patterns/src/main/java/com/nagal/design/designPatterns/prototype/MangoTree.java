package com.nagal.design.designPatterns.prototype;

public class MangoTree extends Tree {

	private String name;

	public MangoTree(double mass,double height){
		super(mass,height);
		this.name="MangoTree";
	}

	public String getName() {
		return name;
	}

	@Override
	public Tree copy(){
		MangoTree mangoTreeClone=new MangoTree(this.getMass(),this.getHeight());
		mangoTreeClone.setPosition(this.getPosition());
		return mangoTreeClone;
	}

}


//https://www.baeldung.com/java-pattern-prototype