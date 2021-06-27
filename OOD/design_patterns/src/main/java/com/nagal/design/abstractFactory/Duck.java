package com.nagal.design.abstractFactory;

public class Duck implements Animal {

	@Override
	public String getAnimal(){
		return "This is a Duck";
	}

	@Override
	public String getSound(){
		return "Duck Sound";
	}

}
