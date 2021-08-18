package com.nagal.design.designPatterns.abstractFactory;

public class Dog implements Animal {

	@Override
	public String getAnimal(){
		return "This is a Dog";
	}

	@Override
	public String getSound(){
		return "Dog Sound";
	}

}
