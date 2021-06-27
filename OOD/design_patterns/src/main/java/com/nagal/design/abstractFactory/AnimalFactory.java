package com.nagal.design.abstractFactory;

import com.nagal.design.abstractFactory.AbstractFactory;
import com.nagal.design.abstractFactory.Animal;
import com.nagal.design.abstractFactory.Dog;
import com.nagal.design.abstractFactory.Duck;

public class AnimalFactory implements AbstractFactory<Animal> {

	@Override
	public Animal create(String animalType) {
		if ("Dog".equalsIgnoreCase(animalType)) {
			return new Dog();
		} else if ("Duck".equalsIgnoreCase(animalType)) {
			return new Duck();
		}

		return null;
	}

}
