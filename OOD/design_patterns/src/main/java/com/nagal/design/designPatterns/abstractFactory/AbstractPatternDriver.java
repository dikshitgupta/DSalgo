package com.nagal.design.designPatterns.abstractFactory;

public class AbstractPatternDriver {

	public static void main(String[] args) {
		AbstractFactory abstractFactory;

		//creating a brown toy dog
		abstractFactory = FactoryProvider.getFactory("Toy");
		Animal toy =(Animal) abstractFactory.create("Dog");

		abstractFactory = FactoryProvider.getFactory("Color");
		Color color =(Color) abstractFactory.create("Brown");

		String result = "A " + toy.getAnimal() + " with " + color.getColor() + " color " + toy.getSound();

		System.out.println(result);
	}
}
